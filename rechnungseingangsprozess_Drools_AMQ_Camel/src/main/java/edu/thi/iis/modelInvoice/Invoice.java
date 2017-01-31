package edu.thi.iis.modelInvoice;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Alexander Hauke
 */

public class Invoice implements Serializable{

    private static final long serialVersionUID = 1L;
    private long value;
    private String supplier;
    private LocalDate invoiceDate;
    private String invoiceNr;
    private String iban;
    private String bic;
    
    /*public Invoice(){
        
    }

    public Invoice(long value, String supplier, LocalDate invoiceDate, String iban, String bic) {
        super();
        this.value = value;
        this.supplier = supplier;
        this.invoiceDate = invoiceDate;
        this.iban = iban;
        this.bic = bic;
    }*/
    
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public String getInvoiceNr() {
        return invoiceNr;
    }
    public void setInvoiceNr(String invoiceNr) {
        this.invoiceNr = invoiceNr;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getBic() {
        return bic;
    }
    public void setBic(String bic) {
        this.bic = bic;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public long getValue() {
        return value;
    }
    public void setValue(long value) {
        this.value = value;
    }

}
