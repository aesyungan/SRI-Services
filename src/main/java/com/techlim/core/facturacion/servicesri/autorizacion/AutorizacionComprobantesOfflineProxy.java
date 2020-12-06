package com.techlim.core.facturacion.servicesri.autorizacion;

public class AutorizacionComprobantesOfflineProxy implements com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOffline {
  private String _endpoint = null;
  private com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOffline autorizacionComprobantesOffline = null;
  
  public AutorizacionComprobantesOfflineProxy() {
    _initAutorizacionComprobantesOfflineProxy();
  }
  
  public AutorizacionComprobantesOfflineProxy(String endpoint) {
    _endpoint = endpoint;
    _initAutorizacionComprobantesOfflineProxy();
  }
  
  private void _initAutorizacionComprobantesOfflineProxy() {
    try {
      autorizacionComprobantesOffline = (new com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOfflineServiceLocator()).getAutorizacionComprobantesOfflinePort();
      if (autorizacionComprobantesOffline != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)autorizacionComprobantesOffline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)autorizacionComprobantesOffline)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (autorizacionComprobantesOffline != null)
      ((javax.xml.rpc.Stub)autorizacionComprobantesOffline)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOffline getAutorizacionComprobantesOffline() {
    if (autorizacionComprobantesOffline == null)
      _initAutorizacionComprobantesOfflineProxy();
    return autorizacionComprobantesOffline;
  }
  
  public com.techlim.core.facturacion.servicesri.autorizacion.RespuestaComprobante autorizacionComprobante(java.lang.String claveAccesoComprobante) throws java.rmi.RemoteException{
    if (autorizacionComprobantesOffline == null)
      _initAutorizacionComprobantesOfflineProxy();
    return autorizacionComprobantesOffline.autorizacionComprobante(claveAccesoComprobante);
  }
  
  public com.techlim.core.facturacion.servicesri.autorizacion.RespuestaLote autorizacionComprobanteLote(java.lang.String claveAccesoLote) throws java.rmi.RemoteException{
    if (autorizacionComprobantesOffline == null)
      _initAutorizacionComprobantesOfflineProxy();
    return autorizacionComprobantesOffline.autorizacionComprobanteLote(claveAccesoLote);
  }
  
  
}