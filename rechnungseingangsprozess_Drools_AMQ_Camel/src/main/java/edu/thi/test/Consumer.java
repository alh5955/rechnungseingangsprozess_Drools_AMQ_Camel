package edu.thi.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

public class Consumer {

    public static void main(String[] args) throws JMSException {
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        Destination destination;
        Connection connection = null;

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
        connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        destination = session.createQueue("ActivitiQueue");

        MessageConsumer consumer = session.createConsumer(destination);

        MessageListener listner = new MessageListener() {
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;

                    // Create Process via REST API
                    try {
                        startProcess(textMessage);
                    } catch (JMSException e) {
                        System.out.println(e);
                        e.printStackTrace();
                    }

                }
            }
        };
        consumer.setMessageListener(listner);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.close();

    }

    protected static void startProcess(TextMessage textMessage) throws JMSException {
        final String START_PROCESS_URL = "http://localhost:8080/activiti-rest/service/runtime/process-instances";

        List<Variable> variables = new ArrayList<Variable>();
        Variable variable = new Variable();
        variable.setName("invoiceValue");
        variable.setValue(textMessage.getText());

        /*Variable variable2 = new Variable();
        variable2.setName("secondParam");
        variable2.setValue(new Long(2L));*/

        variables.add(variable);
        //variables.add(variable2);
        //System.out.println(textMessage.getText());

        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature authenticationFeature = HttpAuthenticationFeature.basic("piggy", "piggy");

        // Registering features
        client.register(JacksonFeature.class);
        client.register(authenticationFeature);

        StartProcessParamsTest startParams = new StartProcessParamsTest();
        startParams.setMessage("ActiveMQMessage");
        startParams.setVariables(variables);
        Response result = client.target(START_PROCESS_URL).request()
                .post(Entity.entity(startParams, MediaType.APPLICATION_JSON), Response.class);

        System.out.println("Process Instance ID: " + result.readEntity(String.class));
    }

}