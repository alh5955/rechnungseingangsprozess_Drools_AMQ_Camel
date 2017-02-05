package edu.thi.iis.mailing.sender;

import java.util.Arrays;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

/**
 * 
 * @author Nadine Zaffrahn
 *
 *         This Class has to be called manually for test reasons. In real case
 *         scenarios the JSON on file system would be detected automatically.
 * 
 *         Purpose: Take mail data in JSON format from file system, parse it to
 *         XML format and save it on file system again. Possible real case
 *         scenario: transfer XML data to mail server or letter printing system
 *         (PDF printer)
 */
public class MailJsonToXML {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            // add route in the context
            context.addRoutes(new RouteBuilder() {
                public void configure() {

                    XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
                    xmlJsonFormat.setEncoding("UTF-8");
                    xmlJsonFormat.setRootName("newRoot");
                    xmlJsonFormat.setExpandableProperties(Arrays.asList("d", "e"));

                    from("file:MailData/outbox").log("before  ${body}").unmarshal(xmlJsonFormat).log("after  ${body}")
                            .to("file:MailData/inbox?fileName=Maildata.xml");
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
        }
    }
}
