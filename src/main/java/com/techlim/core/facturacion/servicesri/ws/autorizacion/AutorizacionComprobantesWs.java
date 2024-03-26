package com.techlim.core.facturacion.servicesri.ws.autorizacion;

import com.techlim.core.facturacion.servicesri.autorizacion.*;
import com.techlim.core.facturacion.servicesri.util.enums.TipoEmisionEnum;

import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorizacionComprobantesWs {

    private final AutorizacionComprobantesOffline service;

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

    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        RespuestaComprobante response = null;
        int intentosMaximos = 3;
        int intentosRealizados = 0;
        boolean exito = false;
        while (intentosRealizados < intentosMaximos && !exito) {
            intentosRealizados++;
            try {
                response = service.autorizacionComprobante(claveDeAcceso);
                exito = true;
            } catch (Exception e) {
                Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
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

    public RespuestaLote llamadaWsAutorizacionLote(String claveDeAcceso) {
        RespuestaLote response = null;
        try {
            response = service.autorizacionComprobanteLote(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);

        }
        return response;
    }
}
