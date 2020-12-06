package com.techlim.core.facturacion.servicesri.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;

import javax.xml.xpath.XPathConstants;

import com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion;
import com.techlim.core.facturacion.servicesri.util.xml.LectorXPath;
import com.techlim.core.facturacion.servicesri.util.xml.XStreamUtil;

public class ArchivoUtils {

    public static boolean byteToFile(byte[] arrayBytes, String rutaArchivo) {
        boolean respuesta = false;
        try {
            File file = new File(rutaArchivo);
            file.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayBytes);
            OutputStream outputStream = new FileOutputStream(rutaArchivo);

            int data;
            while ((data = byteArrayInputStream.read()) != -1) {
                outputStream.write(data);
            }

            fileInputStream.close();
            outputStream.close();
            respuesta = true;
        } catch (IOException ex) {
            //LOG.error(ex);
        }
        return respuesta;
    }

    public static byte[] archivoToByte(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    public static File stringToArchivo(String rutaArchivo, String contenidoArchivo) throws Exception {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(rutaArchivo);
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            for (int i = 0; i < contenidoArchivo.length(); i++) {
                out.write(contenidoArchivo.charAt(i));
            }
            out.close();

            return new File(rutaArchivo);
        } catch (Exception ex) {
            throw ex;

        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

    public static String obtieneClaveAccesoAutorizacion(Autorizacion item) throws Exception {
        String claveAcceso = null;

        String xmlAutorizacion = "";//XStreamUtil.getRespuestaLoteXStream().toXML(item);
        File archivoTemporal = new File("temp.xml");

        stringToArchivo(archivoTemporal.getPath(), xmlAutorizacion);
        String contenidoXML = decodeArchivoBase64(archivoTemporal.getPath());

        if (contenidoXML != null) {
            stringToArchivo(archivoTemporal.getPath(), contenidoXML);
            claveAcceso = obtenerValorXML(archivoTemporal, "/*/infoTributaria/claveAcceso");
        }

        return claveAcceso;
    }
    public static String decodeArchivoBase64(String pathArchivo) {
        String xmlDecodificado = null;
        try {
            File file = new File(pathArchivo);
            if (file.exists()) {
                String encd = obtenerValorXML(file, "/*/comprobante");

                xmlDecodificado = encd;
            } else {
                System.out.print("File not found!");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return xmlDecodificado;
  }
    public static String obtenerValorXML(File xmlDocument, String expression)
    {
        String valor = null;
        try {
            LectorXPath reader = new LectorXPath(xmlDocument.getPath());
            valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
        } catch (Exception ex) {
           throw  ex;
        }

        return valor;
   }
}
