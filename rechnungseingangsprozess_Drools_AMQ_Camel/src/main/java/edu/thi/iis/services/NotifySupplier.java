package edu.thi.iis.services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.iis.mailing.sender.MailSender;
import edu.thi.iis.ws.InvoiceModelWS;
import edu.thi.iis.ws.InvoiceWebService;
import edu.thi.iis.ws.InvoiceWebServiceProxy;

/**
 * 
 * @author Nadine Zaffrahn
 *
 */
public class NotifySupplier implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        InvoiceModelWS invoice = (InvoiceModelWS) execution.getVariable("invoice");
        InvoiceWebService invoiceWebService = new InvoiceWebServiceProxy().getInvoiceWebService();

        invoiceWebService.updateInvoiceStatus(invoice.getInternalID(), "REJECTED");
        invoiceWebService.updateInvoiceApprover(invoice.getInternalID(), invoice.getApproverWorkingPosition());

        MailSender.sendMail(invoice,
                ("Die Rechnung kann nicht bearbeitet werden. "
                        + "Bitte korrigieren Sie die Rechnung gemaess der nachfolgend "
                        + "genannten Anmerkungen und reichen Sie sie erneut ein: "
                        + (String) execution.getVariable("statusComment")));


    }
}
