/**
 * InvoiceWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.thi.iis.ws;

public interface InvoiceWebService extends java.rmi.Remote {
    public edu.thi.iis.ws.InvoiceModelWS createInvoice(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public edu.thi.iis.ws.Employee getEmployeeByWorkingPosition(java.lang.String arg0) throws java.rmi.RemoteException;
    public void updateInvoiceStatus(java.lang.Long arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void updateInvoiceApprover(java.lang.Long arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public edu.thi.iis.ws.InvoiceModelWS getInvoiceByInternalID(java.lang.Long arg0) throws java.rmi.RemoteException;
}
