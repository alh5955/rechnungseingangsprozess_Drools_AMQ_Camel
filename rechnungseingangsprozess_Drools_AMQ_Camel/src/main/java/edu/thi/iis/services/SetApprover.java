package edu.thi.iis.services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.iis.modelInvoice.Decision;
import edu.thi.iis.ws.Employee;
import edu.thi.iis.ws.InvoiceModelWS;
import edu.thi.iis.ws.InvoiceWebService;
import edu.thi.iis.ws.InvoiceWebServiceProxy;

/**
 * 
 * @author Nadine Zaffrahn
 *
 */
public class SetApprover implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Decision decision = (Decision) execution.getVariable("decision");
        InvoiceModelWS invoice = decision.getInvoice();
        if (invoice.getApproverFirstname().equals("")) {
            InvoiceWebService invoiceWebService = new InvoiceWebServiceProxy().getInvoiceWebService();

            Employee employee = invoiceWebService.getEmployeeByWorkingPosition(invoice.getApproverWorkingPosition());

            invoice.setApproverFirstname(employee.getFirstname());
            invoice.setApproverLastname(employee.getLastname());
            invoice.setApproverWorkingPosition(employee.getWorkingPosition().toString());
        }
        execution.setVariable("invoice", invoice);
        execution.setVariable("calculatedAssignee", invoice.getApproverWorkingPosition().toLowerCase());
    }

}
