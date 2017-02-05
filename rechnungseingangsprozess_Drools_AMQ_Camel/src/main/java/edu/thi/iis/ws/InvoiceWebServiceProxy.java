package edu.thi.iis.ws;

public class InvoiceWebServiceProxy implements edu.thi.iis.ws.InvoiceWebService {
  private String _endpoint = null;
  private edu.thi.iis.ws.InvoiceWebService invoiceWebService = null;
  
  public InvoiceWebServiceProxy() {
    _initInvoiceWebServiceProxy();
  }
  
  public InvoiceWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initInvoiceWebServiceProxy();
  }
  
  private void _initInvoiceWebServiceProxy() {
    try {
      invoiceWebService = (new edu.thi.iis.ws.InvoiceWebServiceServiceLocator()).getInvoiceWebServicePort();
      if (invoiceWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)invoiceWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)invoiceWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (invoiceWebService != null)
      ((javax.xml.rpc.Stub)invoiceWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.thi.iis.ws.InvoiceWebService getInvoiceWebService() {
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    return invoiceWebService;
  }
  
  public edu.thi.iis.ws.InvoiceModelWS createInvoice(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    return invoiceWebService.createInvoice(arg0, arg1, arg2, arg3);
  }
  
  public void updateInvoiceStatus(java.lang.Long arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    invoiceWebService.updateInvoiceStatus(arg0, arg1);
  }
  
  public void updateInvoiceApprover(java.lang.Long arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    invoiceWebService.updateInvoiceApprover(arg0, arg1);
  }
  
  public edu.thi.iis.ws.InvoiceModelWS getInvoiceByInternalID(java.lang.Long arg0) throws java.rmi.RemoteException{
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    return invoiceWebService.getInvoiceByInternalID(arg0);
  }
  
  public edu.thi.iis.ws.Employee getEmployeeByWorkingPosition(java.lang.String arg0) throws java.rmi.RemoteException{
    if (invoiceWebService == null)
      _initInvoiceWebServiceProxy();
    return invoiceWebService.getEmployeeByWorkingPosition(arg0);
  }
  
  
}