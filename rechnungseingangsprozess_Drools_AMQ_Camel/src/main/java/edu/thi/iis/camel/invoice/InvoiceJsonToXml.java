package edu.thi.iis.camel.invoice;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

import java.util.Arrays;

/**
 * @author Alexander Hauke
 */

public class InvoiceJsonToXml {
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
    //public void createInvoiceXml() throws Exception{
        CamelContext context = new DefaultCamelContext();
        try {
            // add route in the context
            context.addRoutes(new RouteBuilder() {
                public void configure() {

                    XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
                    xmlJsonFormat.setEncoding("UTF-8");
                    xmlJsonFormat.setRootName("newRoot");
                    xmlJsonFormat.setExpandableProperties(Arrays.asList("d", "e"));

                    from("file:data")    
                            .log("before  ${body}")
                            .unmarshal(xmlJsonFormat)
                            .log("after  ${body}")
                            .to("file:data/InvoiceXmlFiles?fileName=invoiceXml.xml");        
                }
            });
            // start and stop context after 5s
            context.start();
            // Timing
            Thread.sleep(5000);
            // stop context
            context.stop();
        } finally {
            // stop context if error detected
            context.stop();
        }}}
//}
    