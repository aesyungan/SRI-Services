/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techlim.core.facturacion.servicesri.util.enums;

/**
 *
 * @author Alex
 */
public enum TipoEmisionEnum {
    NORMAL(1, "NORMAL"), PREAUTORIZADA(2, "INDISPONIBILIDAD DE SISTEMA");
    private int id;
    private String code;

    private TipoEmisionEnum(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
