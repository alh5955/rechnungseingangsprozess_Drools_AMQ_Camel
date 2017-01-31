package edu.thi.iis.modelInvoice;
import java.io.Serializable;

/**
 * @author Alexander Hauke
 */

public class Decision implements Serializable{

    private static final long serialVersionUID = 1L;
    private Invoice invoice;
    private ResponsiblePerson rp;
    
    public Invoice getInvoice() {
        return invoice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public ResponsiblePerson getRp() {
        return rp;
    }
    public void setRp(ResponsiblePerson rp) {
        this.rp = rp;
    }
}
