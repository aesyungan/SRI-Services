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
public enum EstadoComprobanteEnum {
    ESTADO_RECIBIDA("RECIBIDA"), ESTADO_DEVUELTA("DEVUELTA"), ESTADO_OTRO("OTRO");

    private EstadoComprobanteEnum(String state) {
        this.state = state;
    }

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
