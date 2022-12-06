package com.techlim.core.facturacion.servicesri.ws.autorizacion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion;
import com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOffline;
import com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOfflineService;
import com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOfflineServiceLocator;
import com.techlim.core.facturacion.servicesri.autorizacion.AutorizacionComprobantesOfflineServiceSoapBindingStub;
import com.techlim.core.facturacion.servicesri.autorizacion.Mensaje;
import com.techlim.core.facturacion.servicesri.autorizacion.RespuestaComprobante;
import com.techlim.core.facturacion.servicesri.autorizacion.RespuestaLote;
import com.techlim.core.facturacion.servicesri.util.enums.TipoEmisionEnum;
import java.net.URL;

public class AutorizacionComprobantesWs {

    private AutorizacionComprobantesOffline service;

    /*     */
    public AutorizacionComprobantesWs(String wsdlLocation) throws Exception {
        try {
        	System.setProperty("https.protocols", "SSLv3");
            AutorizacionComprobantesOfflineServiceLocator ser = new AutorizacionComprobantesOfflineServiceLocator();
            service = new AutorizacionComprobantesOfflineServiceSoapBindingStub(new URL(wsdlLocation), ser);
        } catch (Exception ex) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        RespuestaComprobante response = null;
        try {
            response = service.autorizacionComprobante(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);

        }

        return response;
    }

    public RespuestaLote llamadaWsAutorizacionLote(String claveDeAcceso) {
        RespuestaLote response = null;
        try {
            response = service.autorizacionComprobanteLote(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);

        }
        return response;
    }

    public static String obtieneMensajesAutorizacion(Autorizacion autorizacion) {
        StringBuilder mensaje = new StringBuilder();
        for (Mensaje m : autorizacion.getMensajes()) {
            if (m.getInformacionAdicional() != null) {
                mensaje.append("\n" + m.getMensaje() + ": " + m.getInformacionAdicional());
            } else {
                mensaje.append("\n" + m.getMensaje());
            }
        }

        return mensaje.toString();
    }

    public static TipoEmisionEnum verificarOCSP(Autorizacion autorizacion) throws SQLException, ClassNotFoundException {
        boolean respuesta = true;
        TipoEmisionEnum tipoEmisionEnum = TipoEmisionEnum.NORMAL;
        for (Mensaje m : autorizacion.getMensajes()) {
            if (m.getIdentificador().equals("61")) {
                System.out.println("No se puede validar el certificado digital.\n Desea emitir en contingencia?");
                tipoEmisionEnum = TipoEmisionEnum.PREAUTORIZADA;
                // int i = JOptionPane.showConfirmDialog(null, "No se puede validar el
                // certificado digital.\n Desea emitir en contingencia?", "Advertencia", 0);
//                if (i == 0) {
//                    Emisor emisor = new EmisorSQL().obtenerDatosEmisor();
//                    FormGenerales.actualizaEmisor(TipoEmisionEnum.PREAUTORIZADA.getCode(), emisor);
//                }
                respuesta = false;
            }
        }
        return tipoEmisionEnum;
    }
}
