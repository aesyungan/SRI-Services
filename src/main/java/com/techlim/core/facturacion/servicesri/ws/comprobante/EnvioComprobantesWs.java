package com.techlim.core.facturacion.servicesri.ws.comprobante;

import java.io.File;
import java.net.MalformedURLException;

import javax.xml.namespace.QName;

import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOffline;
import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineService;
import com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceLocator;
import com.techlim.core.facturacion.servicesri.recepcion.RespuestaSolicitud;
import com.techlim.core.facturacion.servicesri.util.ArchivoUtils;
import java.net.URL;
import org.apache.axis.AxisFault;

public class EnvioComprobantesWs {

    private RecepcionComprobantesOffline service;
    private static final String VERSION = "1.0.0";

    public EnvioComprobantesWs(String wsdlLocation) throws MalformedURLException, Exception {
        /*javax.xml.namespace.QName qname = new QName("http://ec.gob.sri.ws.recepcion",
                "RecepcionComprobantesOfflineService");*/
        RecepcionComprobantesOfflineService ser = new RecepcionComprobantesOfflineServiceLocator();
       service = new com.techlim.core.facturacion.servicesri.recepcion.RecepcionComprobantesOfflineServiceSoapBindingStub(new URL(wsdlLocation), ser);
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
        try {
            //  RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();

            response = service.validarComprobante(xml);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
            response = new RespuestaSolicitud();
            response.setEstado(e.getMessage());
            return response;
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

}
