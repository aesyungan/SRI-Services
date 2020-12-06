/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techlim.core.facturacion.servicesri;

import java.io.File;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import com.techlim.core.facturacion.servicesri.recepcion.RespuestaSolicitud;
import com.techlim.core.facturacion.servicesri.ws.comprobante.EnvioComprobantesWs;

/**
 *
 * @author Alex
 */
public class RecepcionTest {

    public RecepcionTest() {

    }

    @Test
    public void TestEnvioXML() {
        // para capturar tramas
//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "8888");
//        System.setProperty("https.proxyPort", "8888");
        // prepare
        String expected = "{\"estado\":\"DEVUELTA\",\"comprobantes\":[{\"claveAcceso\":\"3110201901099000573700120010011183877400105361110\",\"mensajes\":[{\"identificador\":\"65\",\"mensaje\":\"FECHA EMISIÓN EXTEMPORANEA\",\"informacionAdicional\":\"La fecha de emisión está fuera del rango de tolerancia [43201 minutos], o es mayor a la fecha del servidor\",\"tipo\":\"ERROR\",\"__hashCodeCalc\":false}],\"__hashCodeCalc\":false}],\"__hashCodeCalc\":false}";
        try {
            EnvioComprobantesWs comprobantesWs = new EnvioComprobantesWs(
                    "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl");
            String path = "src/main/resources/expected/0990005737001-01-001-001-118387740-autorizado.xml";
            File file = new File(path);
            System.out.println("Name file:" + file.getName());
            System.out.println("path file:" + file.getAbsolutePath());
            byte[] xml = Files.readAllBytes(file.toPath());
            // act
            RespuestaSolicitud result = comprobantesWs.enviarComprobanteLotes("", xml, "", "");
            // assert
            Gson gson = new Gson();

            // System.out.println(comprobantesWs.obtenerMensajeRespuesta(result));
            String res = gson.toJson(result);
            System.out.println(gson.toJson(res));
            assertEquals(expected, res);

        } catch (Exception e) {

            System.err.println("" + e.getMessage());
            assertEquals(expected, e.getMessage());
        }

    }
}
