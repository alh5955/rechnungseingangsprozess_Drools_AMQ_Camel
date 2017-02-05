package edu.thi.iis.services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.thi.iis.modelInvoice.Decision;
import edu.thi.iis.ws.InvoiceModelWS;

/**
 * @author Alexander Hauke
 */

public class CreateDecision implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        InvoiceModelWS invoice = (InvoiceModelWS) execution.getVariable("invoice");

        Decision decision = new Decision();
        decision.setInvoice(invoice);

        execution.setVariable("decision", decision);
    }
}