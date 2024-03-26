package com.techlim.core.facturacion.servicesri.ws.comprobante;

import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline;
import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineService;
import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceLocator;
import com.techlim.core.facturacion.servicesri.recepcion.RespuestaSolicitud;
import com.techlim.core.facturacion.servicesri.util.ArchivoUtils;

import java.io.File;
import java.net.URL;

public class EnvioComprobantesWs {

    private static final String VERSION = "1.0.0";
    private final RecepcionComprobantesOffline service;

    public EnvioComprobantesWs(String wsdlLocation) throws Exception {
        /*javax.xml.namespace.QName qname = new QName("http://ec.gob.sri.ws.recepcion",
                "RecepcionComprobantesOfflineService");*/
        System.setProperty("https.protocols", "SSLv3");
        RecepcionComprobantesOfflineService ser = new RecepcionComprobantesOfflineServiceLocator();
        service = new com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub(new URL(wsdlLocation), ser);
    }

    public static RespuestaSolicitud obtenerRespuestaEnvio(File archivo, String ruc, String tipoComprobante,
                                                           String claveDeAcceso, String urlWsdl) {
        RespuestaSolicitud respuesta = new RespuestaSolicitud();
        EnvioComprobantesWs cliente = null;
        try {
            cliente = new EnvioComprobantesWs(urlWsdl);
        } catch (Exception ex) {
            //Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setEstado(ex.getMessage());
            return respuesta;
        }
        respuesta = cliente.enviarComprobante(ruc, archivo, tipoComprobante, "1.0.0");

        return respuesta;
    }

    public static RespuestaSolicitud obtenerRespuestaEnvio1(File archivo, String ruc, String tipoComprobante,
                                                            String claveDeAcceso, String urlWsdl) {
        RespuestaSolicitud respuesta = new RespuestaSolicitud();
        EnvioComprobantesWs cliente = null;
        try {
            cliente = new EnvioComprobantesWs(urlWsdl);
        } catch (Exception ex) {
            //Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setEstado(ex.getMessage());
            return respuesta;
        }
        respuesta = cliente.enviarComprobante(ruc, archivo, tipoComprobante, VERSION);

        return respuesta;
    }

    public RespuestaSolicitud enviarComprobante(String ruc, File xmlFile, String tipoComprobante, String versionXsd) {
        RespuestaSolicitud response = null;
        try {
            //  RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();
            response = service.validarComprobante(ArchivoUtils.archivoToByte(xmlFile));
        } catch (Exception e) {
            //Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
            response = new RespuestaSolicitud();
            response.setEstado(e.getMessage());
            return response;
        }

        return response;
    }

    public RespuestaSolicitud enviarComprobanteLotes(String ruc, byte[] xml, String tipoComprobante,
                                                     String versionXsd) {
        RespuestaSolicitud response = null;
        int intentosMaximos = 3;
        int intentosRealizados = 0;
        boolean exito = false;
        while (intentosRealizados < intentosMaximos && !exito) {
            intentosRealizados++;
            try {
                response = service.validarComprobante(xml);
                exito = true;
            } catch (Exception e) {
                System.err.println("Error al enviar el comprobante: " + e.getMessage());
                response = new RespuestaSolicitud();
                response.setEstado(e.getMessage());
                if (intentosRealizados < intentosMaximos) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        return response;
    }

    public RespuestaSolicitud enviarComprobanteLotes(String ruc, File xml, String tipoComprobante, String versionXsd) {
        RespuestaSolicitud response = null;
        try {
            // RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();
            response = service.validarComprobante(ArchivoUtils.archivoToByte(xml));
        } catch (Exception e) {
            //Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
            response = new RespuestaSolicitud();
            response.setEstado(e.getMessage());
            return response;
        }
        return response;
    }

}
