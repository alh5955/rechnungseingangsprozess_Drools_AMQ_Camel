package edu.thi.jpa.ws;

public class InvoiceServiceProxy implements edu.thi.jpa.ws.InvoiceService {
  private String _endpoint = null;
  private edu.thi.jpa.ws.InvoiceService invoiceService = null;
  
  public InvoiceServiceProxy() {
    _initInvoiceServiceProxy();
  }
  
  public InvoiceServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initInvoiceServiceProxy();
  }
  
  private void _initInvoiceServiceProxy() {
    try {
      invoiceService = (new edu.thi.jpa.ws.InvoiceServiceServiceLocator()).getInvoiceServicePort();
      if (invoiceService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)invoiceService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)invoiceService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (invoiceService != null)
      ((javax.xml.rpc.Stub)invoiceService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.thi.jpa.ws.InvoiceService getInvoiceService() {
    if (invoiceService == null)
      _initInvoiceServiceProxy();
    return invoiceService;
  }
  
  public edu.thi.jpa.ws.Invoice createInvoice(java.lang.String arg0, double arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (invoiceService == null)
      _initInvoiceServiceProxy();
    return invoiceService.createInvoice(arg0, arg1, arg2, arg3);
  }
  
  
}