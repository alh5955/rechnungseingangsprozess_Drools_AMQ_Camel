package edu.thi.iis.services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.iis.ws.InvoiceModelWS;
import edu.thi.iis.ws.InvoiceWebService;
import edu.thi.iis.ws.InvoiceWebServiceProxy;
/**
 * 
 * @author Nadine Zaffrahn
 *
 */
public class CreateInvoice implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String externalId = (String) execution.getVariable("externalId");
        String invoiceDate = (String) execution.getVariable("invoiceDate");
        String value = (String) execution.getVariable("value");
        String supplier_companyName = (String) execution.getVariable("supplier_companyName");

        InvoiceWebService invoiceWebService = new InvoiceWebServiceProxy().getInvoiceWebService();
        InvoiceModelWS invoice = invoiceWebService.createInvoice(externalId, supplier_companyName, invoiceDate, value);
        System.out.println(invoice.getCompanyName()+"   "+invoice.getIndustry());
        execution.setVariable("invoice", invoice);
        
    }
}
