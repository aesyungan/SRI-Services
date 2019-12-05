/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techlim.core.facturacion.servicesri;

import com.google.gson.Gson;
import com.techlim.core.facturacion.servicesri.ws.comprobante.EnvioComprobantesWs;
import com.techlim.core.facturacion.servicesri.ws.comprobante.RespuestaSolicitud;
import java.io.File;
import java.nio.file.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex
 */
public class RecepcionTest {

    public RecepcionTest() {

    }

    @Test
    public void TestEnvioXML() {
        //prepare
        String expected = "{\"estado\":\"DEVUELTA\",\"comprobantes\":{\"comprobante\":[{\"claveAcceso\":\"3110201901099000573700120010011183877400105361110\",\"mensajes\":{\"mensaje\":[{\"identificador\":\"65\",\"mensaje\":\"FECHA EMISIÓN EXTEMPORANEA\",\"informacionAdicional\":\"La fecha de emisión está fuera del rango de tolerancia [43201 minutos], o es mayor a la fecha del servidor\",\"tipo\":\"ERROR\"}]}}]}}";
        try {
            EnvioComprobantesWs comprobantesWs = new EnvioComprobantesWs("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl");
            String path = "src/main/resources/expected/0990005737001-01-001-001-118387740-autorizado.xml";
            File file = new File(path);
            System.out.println("Name file:" + file.getName());
            System.out.println("path file:" + file.getAbsolutePath());
            byte[] xml = Files.readAllBytes(file.toPath());
            //act
            RespuestaSolicitud result = comprobantesWs.enviarComprobanteLotes("", xml, "", "");
            //assert
            Gson gson = new Gson();
            System.out.println(gson.toJson(result));
            //System.out.println(comprobantesWs.obtenerMensajeRespuesta(result));
            assertEquals(expected, gson.toJson(result));

        } catch (Exception e) {

            System.err.println("" + e.getMessage());
            assertEquals(expected, e.getMessage());
        }

    }
}
