//package edu.thi.java.servicetask;
//
//import org.activiti.engine.delegate.DelegateExecution;
//import org.activiti.engine.delegate.JavaDelegate;
//import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.core.MediaType;
//import edu.thi.jpa.ws.Order;
//
//public class CallCreateOrderRest1 implements JavaDelegate {
//
//    @Override
//    public void execute(DelegateExecution execution) throws Exception {
//        String product = (String) execution.getVariable("product");
//        Long quantity = (Long) execution.getVariable("quantity");
//        String comment = (String) execution.getVariable("comment");
//        Order o = new Order();
//        o.setComment(comment);
//        o.setProduct(product);
//        o.setQuantity(quantity.intValue());
//        final String START_PROCESS_URL = "http://localhost:8080/restApp/webapi/orders";
//        Client client = ClientBuilder.newClient();
//        client.register(MoxyJsonFeature.class);
//        Order orderresponse = client.target(START_PROCESS_URL)
//                     .request().accept(MediaType.APPLICATION_JSON)
//                     .post(Entity.entity(o, MediaType.APPLICATION_JSON), Order.class);
//        execution.setVariable("order", orderresponse);
//    }
//
//}
package edu.thi.java.servicetask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.thi.jpa.ws.Invoice;
import edu.thi.jpa.ws.Order;

public class CallCreateInvoiceRest implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String supplier = (String) execution.getVariable("supplier");
        String value = (String) execution.getVariable("value");
        String date = (String) execution.getVariable("date");
        String externalId = (String) execution.getVariable("externalId");
        
        Client client = Client.create();

        WebResource webResource = client
           .resource("http://localhost:8080/restApp/webapi/orders");
        String input = "{\"supplier\":\""+ supplier +"\",\"value\":\""+value+"\",\"date\":"+date+",\"externalId\":"+externalId+"}";
        ClientResponse response = webResource.type("application/json")
           .post(ClientResponse.class, input);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
             + response.getStatus());
         }

         Invoice invoice = response.getEntity(Invoice.class);
         execution.setVariable("invoice", invoice);
    }

}