package com.example.ericfreitez.sertrolsign.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Eric Freitez on 04/05/2017.
 */

public class Empresa {

    @SerializedName("IdEmpresa")
    @Expose
    private String idEmpresa;
    @SerializedName("CodigoEmpresa")
    @Expose
    private String codigoEmpresa;
    @SerializedName("NombreEmpresa")
    @Expose
    private String nombreEmpresa;
    @SerializedName("TelefonoEmpresa")
    @Expose
    private String telefonoEmpresa;
    @SerializedName("DireccionEmpresa")
    @Expose
    private String direccionEmpresa;


    public Empresa(String idEmpresa, String codigoEmpresa, String nombreEmpresa, String telefonoEmpresa, String direccionEmpresa) {
        super();
        this.idEmpresa = idEmpresa;
        this.codigoEmpresa = codigoEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
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
