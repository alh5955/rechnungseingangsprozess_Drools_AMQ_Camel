package edu.thi.iis.mailing.sender;

import org.apache.camel.builder.RouteBuilder;

/**
 * 
 * @author Nadine Zaffrahn
 *
 */
public class RejectedInvoiceRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Take invoice data from queue, parse it into json format an save it to
        // MailData/outbox
        from("jms:queue:MailQueue").marshal().json().to("file:MailData/outbox/");

    }
}
