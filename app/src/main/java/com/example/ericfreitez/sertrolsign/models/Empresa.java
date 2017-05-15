package com.example.ericfreitez.sertrolsign.models;

import java.util.ArrayList;

/**
 * Created by Eric Freitez on 04/05/2017.
 */

public class Empresa {

    private String idEmpresa;
    private String nombreEmpresa;
    private String telefonoEmpresa;
    private String direccionEmpresa;

    public Empresa(String nombreEmpresa, String telefonoEmpresa, String direccionEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }
}
