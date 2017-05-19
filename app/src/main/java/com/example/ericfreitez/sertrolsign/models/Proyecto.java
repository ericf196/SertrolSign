package com.example.ericfreitez.sertrolsign.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * Created by Eric Freitez on 26/04/2017.
 */

public class Proyecto implements Serializable {

    @SerializedName("CodigoProyecto")
    @Expose
    private String codigoProyecto;
    @SerializedName("NombreProyecto")
    @Expose
    private String nombreProyecto;
    @SerializedName("DescripcionProyecto")
    @Expose
    private String descripcionProyecto;

    @SerializedName("FechaCreacion")
    @Expose
    private String fechaCreacion;

    @SerializedName("NombreEmpresa")
    @Expose
    private String nombreEmpresa;

    public Proyecto(String codigoProyecto, String nombreProyecto, String descripcionProyecto, String fechaCreacion, String nombreEmpresa) {
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.fechaCreacion = fechaCreacion;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
