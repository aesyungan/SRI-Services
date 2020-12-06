package com.techlim.core.facturacion.servicesri.recepcion;

public class RecepcionComprobantesOfflineProxy implements com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline {
  private String _endpoint = null;
  private com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline recepcionComprobantesOffline = null;
  
  public RecepcionComprobantesOfflineProxy() {
    _initRecepcionComprobantesOfflineProxy();
  }
  
  public RecepcionComprobantesOfflineProxy(String endpoint) {
    _endpoint = endpoint;
    _initRecepcionComprobantesOfflineProxy();
  }
  
  private void _initRecepcionComprobantesOfflineProxy() {
    try {
      recepcionComprobantesOffline = (new com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceLocator()).getRecepcionComprobantesOfflinePort();
      if (recepcionComprobantesOffline != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)recepcionComprobantesOffline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)recepcionComprobantesOffline)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (recepcionComprobantesOffline != null)
      ((javax.xml.rpc.Stub)recepcionComprobantesOffline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline getRecepcionComprobantesOffline() {
    if (recepcionComprobantesOffline == null)
      _initRecepcionComprobantesOfflineProxy();
    return recepcionComprobantesOffline;
  }
  
  public com.techlim.core.facturacion.servicesri.recepcion.RespuestaSolicitud validarComprobante(byte[] xml) throws java.rmi.RemoteException{
    if (recepcionComprobantesOffline == null)
      _initRecepcionComprobantesOfflineProxy();
    return recepcionComprobantesOffline.validarComprobante(xml);
  }
  
  
}