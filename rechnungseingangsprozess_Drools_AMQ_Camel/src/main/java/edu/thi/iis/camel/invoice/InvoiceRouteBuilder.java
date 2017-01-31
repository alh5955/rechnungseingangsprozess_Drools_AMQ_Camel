package edu.thi.iis.camel.invoice;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author Alexander Hauke
 */

public class InvoiceRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        
        
            from("jms:queue:ActivitiQueue").marshal().json()
            
            //.split().tokenize(",")
           
            //.log("${body}")
            .to("file:data/");
                       
    }
   
   
}