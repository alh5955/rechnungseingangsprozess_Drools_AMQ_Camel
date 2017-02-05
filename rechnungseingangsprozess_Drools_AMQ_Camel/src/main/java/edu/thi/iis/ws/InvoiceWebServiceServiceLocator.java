/**
 * InvoiceWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.thi.iis.ws;

public class InvoiceWebServiceServiceLocator extends org.apache.axis.client.Service implements edu.thi.iis.ws.InvoiceWebServiceService {

    public InvoiceWebServiceServiceLocator() {
    }


    public InvoiceWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InvoiceWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InvoiceWebServicePort
    private java.lang.String InvoiceWebServicePort_address = "http://ikm00-ws16:8080/rechnungseingang_war/InvoiceWebServiceService";

    public java.lang.String getInvoiceWebServicePortAddress() {
        return InvoiceWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InvoiceWebServicePortWSDDServiceName = "InvoiceWebServicePort";

    public java.lang.String getInvoiceWebServicePortWSDDServiceName() {
        return InvoiceWebServicePortWSDDServiceName;
    }

    public void setInvoiceWebServicePortWSDDServiceName(java.lang.String name) {
        InvoiceWebServicePortWSDDServiceName = name;
    }

    public edu.thi.iis.ws.InvoiceWebService getInvoiceWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InvoiceWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInvoiceWebServicePort(endpoint);
    }

    public edu.thi.iis.ws.InvoiceWebService getInvoiceWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.thi.iis.ws.InvoiceWebServicePortBindingStub _stub = new edu.thi.iis.ws.InvoiceWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getInvoiceWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInvoiceWebServicePortEndpointAddress(java.lang.String address) {
        InvoiceWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.thi.iis.ws.InvoiceWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.thi.iis.ws.InvoiceWebServicePortBindingStub _stub = new edu.thi.iis.ws.InvoiceWebServicePortBindingStub(new java.net.URL(InvoiceWebServicePort_address), this);
                _stub.setPortName(getInvoiceWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InvoiceWebServicePort".equals(inputPortName)) {
            return getInvoiceWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.iis.thi.edu/", "InvoiceWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.iis.thi.edu/", "InvoiceWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InvoiceWebServicePort".equals(portName)) {
            setInvoiceWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
