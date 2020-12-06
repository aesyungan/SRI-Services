/**
 * RespuestaComprobante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.techlim.core.facturacion.servicesri.autorizacion;

public class RespuestaComprobante  implements java.io.Serializable {
    private java.lang.String claveAccesoConsultada;

    private java.lang.String numeroComprobantes;

    private com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion[] autorizaciones;

    public RespuestaComprobante() {
    }

    public RespuestaComprobante(
           java.lang.String claveAccesoConsultada,
           java.lang.String numeroComprobantes,
           com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion[] autorizaciones) {
           this.claveAccesoConsultada = claveAccesoConsultada;
           this.numeroComprobantes = numeroComprobantes;
           this.autorizaciones = autorizaciones;
    }


    /**
     * Gets the claveAccesoConsultada value for this RespuestaComprobante.
     * 
     * @return claveAccesoConsultada
     */
    public java.lang.String getClaveAccesoConsultada() {
        return claveAccesoConsultada;
    }


    /**
     * Sets the claveAccesoConsultada value for this RespuestaComprobante.
     * 
     * @param claveAccesoConsultada
     */
    public void setClaveAccesoConsultada(java.lang.String claveAccesoConsultada) {
        this.claveAccesoConsultada = claveAccesoConsultada;
    }


    /**
     * Gets the numeroComprobantes value for this RespuestaComprobante.
     * 
     * @return numeroComprobantes
     */
    public java.lang.String getNumeroComprobantes() {
        return numeroComprobantes;
    }


    /**
     * Sets the numeroComprobantes value for this RespuestaComprobante.
     * 
     * @param numeroComprobantes
     */
    public void setNumeroComprobantes(java.lang.String numeroComprobantes) {
        this.numeroComprobantes = numeroComprobantes;
    }


    /**
     * Gets the autorizaciones value for this RespuestaComprobante.
     * 
     * @return autorizaciones
     */
    public com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion[] getAutorizaciones() {
        return autorizaciones;
    }


    /**
     * Sets the autorizaciones value for this RespuestaComprobante.
     * 
     * @param autorizaciones
     */
    public void setAutorizaciones(com.techlim.core.facturacion.servicesri.autorizacion.Autorizacion[] autorizaciones) {
        this.autorizaciones = autorizaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaComprobante)) return false;
        RespuestaComprobante other = (RespuestaComprobante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveAccesoConsultada==null && other.getClaveAccesoConsultada()==null) || 
             (this.claveAccesoConsultada!=null &&
              this.claveAccesoConsultada.equals(other.getClaveAccesoConsultada()))) &&
            ((this.numeroComprobantes==null && other.getNumeroComprobantes()==null) || 
             (this.numeroComprobantes!=null &&
              this.numeroComprobantes.equals(other.getNumeroComprobantes()))) &&
            ((this.autorizaciones==null && other.getAutorizaciones()==null) || 
             (this.autorizaciones!=null &&
              java.util.Arrays.equals(this.autorizaciones, other.getAutorizaciones())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getClaveAccesoConsultada() != null) {
            _hashCode += getClaveAccesoConsultada().hashCode();
        }
        if (getNumeroComprobantes() != null) {
            _hashCode += getNumeroComprobantes().hashCode();
        }
        if (getAutorizaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAutorizaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAutorizaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaComprobante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "respuestaComprobante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveAccesoConsultada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveAccesoConsultada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroComprobantes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroComprobantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autorizaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autorizaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "autorizacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "autorizacion"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
