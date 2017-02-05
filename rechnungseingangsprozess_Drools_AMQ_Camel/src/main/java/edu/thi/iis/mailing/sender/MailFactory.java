package edu.thi.iis.mailing.sender;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * 
 * @author Nadine Zaffrahn
 * 
 *         This Class has to be called manually for test reasons. In real case
 *         scenarios the queue would be checked automatically.
 * 
 *         Purpose: Take mail data from Queue and parse it to JSON
 *
 */
public class MailFactory {
    public static void main(String[] args) {

        RejectedInvoiceRouteBuilder routeBuilder = new RejectedInvoiceRouteBuilder();
        CamelContext context = new DefaultCamelContext();

        // configure jms component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        // add the jms component to the context
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try {
            context.addRoutes(routeBuilder);
            context.start();
            Thread.sleep(5 * 60 * 1000);
            context.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
