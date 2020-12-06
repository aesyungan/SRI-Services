/**
 * AutorizacionComprobantesOffline.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.techlim.core.facturacion.servicesri.autorizacion;

public interface AutorizacionComprobantesOffline extends java.rmi.Remote {
    public com.techlim.core.facturacion.servicesri.autorizacion.RespuestaComprobante autorizacionComprobante(java.lang.String claveAccesoComprobante) throws java.rmi.RemoteException;
    public com.techlim.core.facturacion.servicesri.autorizacion.RespuestaLote autorizacionComprobanteLote(java.lang.String claveAccesoLote) throws java.rmi.RemoteException;
}
