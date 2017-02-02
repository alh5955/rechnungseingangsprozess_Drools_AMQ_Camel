/**
 * Invoice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.thi.jpa.ws;

public class Invoice  implements java.io.Serializable {
    private java.lang.String invoiceDate;

    private java.lang.String invoiceExternalId;

    private java.lang.Long invoiceId;

    private java.lang.String invoiceSupplier;

    private double invoiceValue;

    public Invoice() {
    }

    public Invoice(
           java.lang.String invoiceDate,
           java.lang.String invoiceExternalId,
           java.lang.Long invoiceId,
           java.lang.String invoiceSupplier,
           double invoiceValue) {
           this.invoiceDate = invoiceDate;
           this.invoiceExternalId = invoiceExternalId;
           this.invoiceId = invoiceId;
           this.invoiceSupplier = invoiceSupplier;
           this.invoiceValue = invoiceValue;
    }


    /**
     * Gets the invoiceDate value for this Invoice.
     * 
     * @return invoiceDate
     */
    public java.lang.String getInvoiceDate() {
        return invoiceDate;
    }


    /**
     * Sets the invoiceDate value for this Invoice.
     * 
     * @param invoiceDate
     */
    public void setInvoiceDate(java.lang.String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }


    /**
     * Gets the invoiceExternalId value for this Invoice.
     * 
     * @return invoiceExternalId
     */
    public java.lang.String getInvoiceExternalId() {
        return invoiceExternalId;
    }


    /**
     * Sets the invoiceExternalId value for this Invoice.
     * 
     * @param invoiceExternalId
     */
    public void setInvoiceExternalId(java.lang.String invoiceExternalId) {
        this.invoiceExternalId = invoiceExternalId;
    }


    /**
     * Gets the invoiceId value for this Invoice.
     * 
     * @return invoiceId
     */
    public java.lang.Long getInvoiceId() {
        return invoiceId;
    }


    /**
     * Sets the invoiceId value for this Invoice.
     * 
     * @param invoiceId
     */
    public void setInvoiceId(java.lang.Long invoiceId) {
        this.invoiceId = invoiceId;
    }


    /**
     * Gets the invoiceSupplier value for this Invoice.
     * 
     * @return invoiceSupplier
     */
    public java.lang.String getInvoiceSupplier() {
        return invoiceSupplier;
    }


    /**
     * Sets the invoiceSupplier value for this Invoice.
     * 
     * @param invoiceSupplier
     */
    public void setInvoiceSupplier(java.lang.String invoiceSupplier) {
        this.invoiceSupplier = invoiceSupplier;
    }


    /**
     * Gets the invoiceValue value for this Invoice.
     * 
     * @return invoiceValue
     */
    public double getInvoiceValue() {
        return invoiceValue;
    }


    /**
     * Sets the invoiceValue value for this Invoice.
     * 
     * @param invoiceValue
     */
    public void setInvoiceValue(double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Invoice)) return false;
        Invoice other = (Invoice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.invoiceDate==null && other.getInvoiceDate()==null) || 
             (this.invoiceDate!=null &&
              this.invoiceDate.equals(other.getInvoiceDate()))) &&
            ((this.invoiceExternalId==null && other.getInvoiceExternalId()==null) || 
             (this.invoiceExternalId!=null &&
              this.invoiceExternalId.equals(other.getInvoiceExternalId()))) &&
            ((this.invoiceId==null && other.getInvoiceId()==null) || 
             (this.invoiceId!=null &&
              this.invoiceId.equals(other.getInvoiceId()))) &&
            ((this.invoiceSupplier==null && other.getInvoiceSupplier()==null) || 
             (this.invoiceSupplier!=null &&
              this.invoiceSupplier.equals(other.getInvoiceSupplier()))) &&
            this.invoiceValue == other.getInvoiceValue();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInvoiceDate() != null) {
            _hashCode += getInvoiceDate().hashCode();
        }
        if (getInvoiceExternalId() != null) {
            _hashCode += getInvoiceExternalId().hashCode();
        }
        if (getInvoiceId() != null) {
            _hashCode += getInvoiceId().hashCode();
        }
        if (getInvoiceSupplier() != null) {
            _hashCode += getInvoiceSupplier().hashCode();
        }
        _hashCode += new Double(getInvoiceValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Invoice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.jpa.thi.edu/", "invoice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceExternalId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceExternalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceSupplier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceSupplier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invoiceValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
