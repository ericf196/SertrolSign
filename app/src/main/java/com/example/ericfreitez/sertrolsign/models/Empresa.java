package com.example.ericfreitez.sertrolsign.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Eric Freitez on 04/05/2017.
 */

public class Empresa {

    @SerializedName("idEmpresa")
    private String idEmpresa;

    @SerializedName("NombreEmpresa")
    private String nombreEmpresa;
    @SerializedName("TelefonoEmpresa")
    private String telefonoEmpresa;
    @SerializedName("DireccionEmpresa")
    private String direccionEmpresa;

    public Empresa(String nombreEmpresa, String telefonoEmpresa, String direccionEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
}
