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
public class TestRecepcion {

    public TestRecepcion() {
    }

    @Test
    public void TestEnvioXML() {
        try {
            EnvioComprobantesWs comprobantesWs = new EnvioComprobantesWs("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl");

            // TODO initialize WS operation arguments here
            String url = "C:\\Users\\Alex\\Downloads\\0990005737001-01-001-001-118387740\\0990005737001-01-001-001-118387740-autorizado.xml";
            File file = new File(url);
            System.out.println("Name:" + file.getName());
            byte[] xml = Files.readAllBytes(file.toPath());
            RespuestaSolicitud result = comprobantesWs.enviarComprobanteLotes("", xml, "", "");
            System.out.println("Result = " + result);
            Gson gson = new Gson();
            System.out.println(gson.toJson(result));

        } catch (Exception e) {
            System.err.println("" + e.getMessage());
        }
    }
}
