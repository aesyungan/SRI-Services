package com.techlim.core.facturacion.servicesri.ws.autorizacion;

import com.techlim.core.facturacion.servicesri.util.ArchivoUtils;
import com.techlim.core.facturacion.servicesri.util.enums.TipoEmisionEnum;
import com.thoughtworks.xstream.XStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class AutorizacionComprobantesWs {

    private AutorizacionComprobantesOfflineService service;

    /*     */
    public AutorizacionComprobantesWs(String wsdlLocation) throws Exception {
        try {
            this.service = new AutorizacionComprobantesOfflineService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService"));
        } catch (Exception ex) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        RespuestaComprobante response = null;
        try {
            AutorizacionComprobantesOffline port = this.service.getAutorizacionComprobantesOfflinePort();
            response = port.autorizacionComprobante(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        return response;
    }

    public RespuestaLote llamadaWsAutorizacionLote(String claveDeAcceso) {
        RespuestaLote response = null;
        try {
            AutorizacionComprobantesOffline port = this.service.getAutorizacionComprobantesOfflinePort();
            response = port.autorizacionComprobanteLote(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return response;
    }

    public static String obtieneMensajesAutorizacion(Autorizacion autorizacion) {
        StringBuilder mensaje = new StringBuilder();
        for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
            if (m.getInformacionAdicional() != null) {
                mensaje.append("\n" + m.getMensaje() + ": " + m.getInformacionAdicional());
            } else {
                mensaje.append("\n" + m.getMensaje());
            }
        }

        return mensaje.toString();
    }

    public static TipoEmisionEnum verificarOCSP(Autorizacion autorizacion)
            throws SQLException, ClassNotFoundException {
        boolean respuesta = true;
        TipoEmisionEnum tipoEmisionEnum = TipoEmisionEnum.NORMAL;
        for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
            if (m.getIdentificador().equals("61")) {
                System.out.println("No se puede validar el certificado digital.\n Desea emitir en contingencia?");
                tipoEmisionEnum = TipoEmisionEnum.PREAUTORIZADA;
                //int i = JOptionPane.showConfirmDialog(null, "No se puede validar el certificado digital.\n Desea emitir en contingencia?", "Advertencia", 0);
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
