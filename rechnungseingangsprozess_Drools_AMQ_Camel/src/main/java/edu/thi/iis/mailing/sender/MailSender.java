package edu.thi.iis.mailing.sender;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import edu.thi.iis.ws.InvoiceModelWS;



/**
 * 
 * @author Nadine Zaffrahn
 *
 */

public class MailSender {
    public static void sendMail(InvoiceModelWS invoice, String messagetext) {
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        Destination destination;

        try {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            // set this property in order to use classes from other packages.
            // disabled in default due to security reasons
            connectionFactory.setTrustAllPackages(true);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("MailQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                        
            MapMessage message = session.createMapMessage();
            message.setString("Betreff", "Ablehnug der Rechnung");
            message.setString("Ihr Zeichen", invoice.getExternalID());
            message.setLong("Unser Zeichen", invoice.getInternalID());
            message.setString("Empfaenger", invoice.getCompanyName());
            message.setString("Strasse", invoice.getStreet());
            message.setString("Hausnummer", invoice.getHousenumber());
            message.setString("PLZ", invoice.getPostcode());
            message.setString("Ort", invoice.getLocation());
            message.setString("Rechnungsbetrag", invoice.getValue());
            message.setString("Rechnungsdatum", invoice.getInvoiceDate());
            message.setString("Grund der Ablehung", messagetext);

            producer.send(message);
            connection.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
