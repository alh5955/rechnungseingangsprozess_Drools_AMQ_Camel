package edu.thi.java.servicetask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.jpa.ws.Invoice;
import edu.thi.jpa.ws.InvoiceService;
import edu.thi.jpa.ws.InvoiceServiceProxy;

public class CallCreateInvoiceWS implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String supplier = (String) execution.getVariable("supplier");
        Double value = (Double) execution.getVariable("value");
        String date = (String) execution.getVariable("date");
        String externalId = (String) execution.getVariable("externalId");
        
        InvoiceService invoiceService = new InvoiceServiceProxy().getInvoiceService();
        Invoice invoice = invoiceService.createInvoice(supplier, value, date, externalId);
        execution.setVariable("invoice", invoice);
    }

}
