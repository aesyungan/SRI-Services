package com.techlim.core.facturacion.servicesri.util;

import com.techlim.core.facturacion.servicesri.util.xml.LectorXPath;
import com.techlim.core.facturacion.servicesri.util.xml.XStreamUtil;
import com.techlim.core.facturacion.servicesri.ws.autorizacion.Autorizacion;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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

        String xmlAutorizacion = XStreamUtil.getRespuestaLoteXStream().toXML(item);
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
