package edu.thi.iis.camel.invoice;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author Alexander Hauke
 */

public class InvoiceCamelFactory {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        InvoiceRouteBuilder routeBuilder = new InvoiceRouteBuilder();
        CamelContext context = new DefaultCamelContext();
        
        //configure jms component        
       ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
       // add the jms component to the context
       context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        try {
            context.addRoutes(routeBuilder);
            context.start();
            Thread.sleep(5 * 60 * 1000);
            context.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}