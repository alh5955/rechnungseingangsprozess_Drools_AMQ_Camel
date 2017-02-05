package edu.thi.iis.modelInvoice;
import java.io.Serializable;

import edu.thi.iis.ws.InvoiceModelWS;

/**
 * @author Alexander Hauke
 */

public class Decision implements Serializable{

    private static final long serialVersionUID = 1L;
//    private Invoice invoice;
//    private ResponsiblePerson rp;
    private InvoiceModelWS invoice;
    
    
    public InvoiceModelWS getInvoice() {
        return invoice;
    }
    public void setInvoice(InvoiceModelWS invoice) {
        this.invoice = invoice;
    }
    
    
//    public ResponsiblePerson getRp() {
//        return rp;
//    }
//    public void setRp(ResponsiblePerson rp) {
//        this.rp = rp;
//    }
}
