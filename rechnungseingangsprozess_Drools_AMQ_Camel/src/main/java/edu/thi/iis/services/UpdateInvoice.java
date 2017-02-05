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
public class UpdateInvoice implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        InvoiceModelWS invoice = (InvoiceModelWS) execution.getVariable("invoice");
        InvoiceWebService invoiceWebService = new InvoiceWebServiceProxy().getInvoiceWebService();

        invoiceWebService.updateInvoiceStatus(invoice.getInternalID(), "APPROVED");
        invoiceWebService.updateInvoiceApprover(invoice.getInternalID(), invoice.getApproverWorkingPosition());

    }

}
