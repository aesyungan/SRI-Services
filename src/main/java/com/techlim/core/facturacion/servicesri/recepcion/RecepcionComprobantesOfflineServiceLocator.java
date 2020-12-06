/**
 * RecepcionComprobantesOfflineServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.techlim.core.facturacion.servicesri.recepcion;

public class RecepcionComprobantesOfflineServiceLocator extends org.apache.axis.client.Service implements com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineService {

    public RecepcionComprobantesOfflineServiceLocator() {
    }


    public RecepcionComprobantesOfflineServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RecepcionComprobantesOfflineServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RecepcionComprobantesOfflinePort
    private java.lang.String RecepcionComprobantesOfflinePort_address = "http://uio11rxvc120809:8080/comprobantes-electronicos-ws/RecepcionComprobantesOffline";

    public java.lang.String getRecepcionComprobantesOfflinePortAddress() {
        return RecepcionComprobantesOfflinePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RecepcionComprobantesOfflinePortWSDDServiceName = "RecepcionComprobantesOfflinePort";

    public java.lang.String getRecepcionComprobantesOfflinePortWSDDServiceName() {
        return RecepcionComprobantesOfflinePortWSDDServiceName;
    }

    public void setRecepcionComprobantesOfflinePortWSDDServiceName(java.lang.String name) {
        RecepcionComprobantesOfflinePortWSDDServiceName = name;
    }

    public com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline getRecepcionComprobantesOfflinePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RecepcionComprobantesOfflinePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRecepcionComprobantesOfflinePort(endpoint);
    }

    public com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline getRecepcionComprobantesOfflinePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub _stub = new com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRecepcionComprobantesOfflinePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRecepcionComprobantesOfflinePortEndpointAddress(java.lang.String address) {
        RecepcionComprobantesOfflinePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline.class.isAssignableFrom(serviceEndpointInterface)) {
                com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub _stub = new com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub(new java.net.URL(RecepcionComprobantesOfflinePort_address), this);
                _stub.setPortName(getRecepcionComprobantesOfflinePortWSDDServiceName());
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
        if ("RecepcionComprobantesOfflinePort".equals(inputPortName)) {
            return getRecepcionComprobantesOfflinePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflineService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflinePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RecepcionComprobantesOfflinePort".equals(portName)) {
            setRecepcionComprobantesOfflinePortEndpointAddress(address);
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
