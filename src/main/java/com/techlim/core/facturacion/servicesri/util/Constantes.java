package com.techlim.core.facturacion.servicesri.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Constantes {

    public static final String ID_FICTICIO_CONSUMIDOR_FINAL = "9999999999999";
    public static final String AUTORIDAD_CERT_NO_DISPONIBLE = "61";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
    public static final Integer LONGITUD_CLAVE_PREAUTORIZADA = Integer.valueOf(8);
    public static final int INTENTOS_CONEXION_WS = 3;
    public static final int INTENTOS_RESPUESTA_AUTORIZACION_WS = 5;
}
