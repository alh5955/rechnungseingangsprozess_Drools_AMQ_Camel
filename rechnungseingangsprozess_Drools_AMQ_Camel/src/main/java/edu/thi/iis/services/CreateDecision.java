package edu.thi.iis.services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.iis.modelInvoice.Decision;
import edu.thi.iis.modelInvoice.Invoice;
import edu.thi.iis.modelInvoice.ResponsiblePerson;

/**
 * @author Alexander Hauke
 */

public class CreateDecision implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String tmp = (String) execution.getVariable("invoiceValue");
        long value = Long.valueOf(tmp).longValue();
        //InvoiceJsonToXml jtx = new InvoiceJsonToXml();
        //jtx.createInvoiceXml();
        //XmlTestClass test = new XmlTestClass();
        //long value = Long.parseLong(test.getXmlValue());
        
        Invoice invoice = new Invoice();
        invoice.setValue(value);

        Decision decision = new Decision();
        decision.setInvoice(invoice);
        decision.setRp(new ResponsiblePerson());

        execution.setVariable("decision", decision);
    }
}