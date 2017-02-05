package edu.thi.test;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author Alexander Hauke
 */

public class InvoiceSender implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
      
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        Destination destination;
        String invoiceValue = (String) execution.getVariable("value");
        String invoiceSupplier = (String) execution.getVariable("supplier");
        String invoiceDate = (String) execution.getVariable("date");
        String invoiceId = (String) execution.getVariable("externalId");
        
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("invoiceValue", invoiceValue);
        data.put("invoiceSupplier", invoiceSupplier);
        data.put("invoiceDate", invoiceDate);
        data.put("invoiceId", invoiceId);
        
        /*Invoice in = new Invoice();
        long inValue = Long.valueOf(invoiceValue).longValue();
        LocalDate inDate = LocalDate.parse(invoiceDate);
        in.setValue(inValue);
        in.setInvoiceDate(inDate);
        in.setSupplier(invoiceSupplier);*/
    
        //System.out.println(invoiceValue);
        
        //CreateInvoiceXml ixml = new CreateInvoiceXml();
        //ixml.InvoiceToXml(textMessage);
        //CreateInvoiceXml cix = new CreateInvoiceXml();
        //cix.InvoiceToXml(textMessage);
        
        try {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("ActivitiQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            
            /*long inValue = Long.valueOf(invoiceValue).longValue();
            LocalDate inDate = LocalDate.parse(invoiceDate);
            Invoice in = new Invoice(inValue, invoiceSupplier, inDate, invoiceIban, invoiceBic);
            in.setValue(inValue);
            in.setInvoiceDate(inDate);
            in.setSupplier(invoiceSupplier);
            
            ObjectMessage message = session.createObjectMessage();*/
            
            MapMessage message = session.createMapMessage();
            message.setString("Rechnungsbetrag", invoiceValue);
            message.setString("Lieferant", invoiceSupplier);
            message.setString("Datum", invoiceDate);
            message.setString("ID", invoiceId);
            
            //TextMessage message = session.createTextMessage(invoiceValue);
            //TextMessage message2 = session.createTextMessage(invoiceSupplier);
            //message.setObject(in);
            producer.send(message);
            //producer.send(message2);
            connection.close();
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        /*RuntimeService runtimeService = execution.getEngineServices().getRuntimeService();
        
        // Search if a process is already waiting at an intermediate event
        Execution waitingExecution = runtimeService.createExecutionQuery()
                  .messageEventSubscriptionName("NewOrderMessage")
                  .processVariableValueEquals("invoiceValue", invoiceValue)
                  .singleResult();
        
        if (waitingExecution != null) {
            // An execution is waiting --> continue it
            runtimeService.messageEventReceived("NewOrderMessage", waitingExecution.getId(), data);
        } else {
            // No execution is waiting --> start a new Aggregator instance
            runtimeService.startProcessInstanceByMessage("NewOrderMessage", data);
        }*/
    }

}
