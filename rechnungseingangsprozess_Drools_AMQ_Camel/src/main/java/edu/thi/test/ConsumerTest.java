package edu.thi.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * @author Alexander Hauke
 */

public class ConsumerTest {

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
            @Override
            public void onMessage(Message message) {
                if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    //MapMessage mapMessage = (MapMessage) message;
                    // Create Process via REST API
                    try {
                        startProcess(mapMessage);
                        //startProcess(textMessage);
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

    protected static void startProcess(MapMessage mapMessage) throws JMSException {
        final String START_PROCESS_URL = "http://localhost:8080/activiti-rest/service/runtime/process-instances";

        Map<String, Object> variables = new HashMap<String, Object>();
        
        variables.put("invoiceValue", mapMessage.getObject("Rechnungsbetrag"));
        variables.put("invoiceSupplier", mapMessage.getObject("Lieferant"));
        variables.put("invoiceDate", mapMessage.getObject("Datum"));
        variables.put("invoiceId", mapMessage.getObject("ID"));
        
        System.out.println(mapMessage.getObject("Rechnungsbetrag"));
        System.out.println(mapMessage.getObject("Lieferant"));
        System.out.println(mapMessage.getObject("Datum"));
        System.out.println(mapMessage.getObject("ID"));

        /*List<VariablesTest> variables = new ArrayList<VariablesTest>();
        VariablesTest invoiceValue = new VariablesTest();
        invoiceValue.setName("invoiceValue");
        invoiceValue.setValue(textMessage.getText());

        variables.add(invoiceValue);
        System.out.println(textMessage.getText());*/
        
        /*VariablesTest invoiceSupplier = new VariablesTest();
        invoiceSupplier.setName("invoiceSupplier");
        invoiceSupplier.setValue(mapMessage.getText());

        variables.add(invoiceSupplier);
        System.out.println(mapMessage.getText());
        
        VariablesTest invoiceDate = new VariablesTest();
        invoiceDate.setName("invoiceDate");
        invoiceDate.setValue(mapMessage.getText());

        variables.add(invoiceDate);
        System.out.println(mapMessage.getText());
        
        VariablesTest invoiceId = new VariablesTest();
        invoiceId.setName("invoiceId");
        invoiceId.setValue(mapMessage.getText());

        variables.add(invoiceId);
        System.out.println(mapMessage.getText());*/

        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature authenticationFeature = HttpAuthenticationFeature.basic("piggy", "piggy");

        // Registering features
        client.register(JacksonFeature.class);
        client.register(authenticationFeature);

        StartProcessParamsTest startParams = new StartProcessParamsTest();
        startParams.setMessage("NewInvoiceMessage");
        startParams.setMapVariables(variables);
        Response result = client.target(START_PROCESS_URL).request()
                .post(Entity.entity(startParams, MediaType.APPLICATION_JSON), Response.class);

        System.out.println("Process Instance ID: " + result.readEntity(String.class));

    }
}