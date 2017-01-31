package edu.thi.iis.modelInvoice;
import java.io.Serializable;

/**
 * @author Alexander Hauke
 */

public class ResponsiblePerson implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    
    public String getValue() {
        return name;
    }
    public void setValue(String name) {
        this.name = name;
    }

}
