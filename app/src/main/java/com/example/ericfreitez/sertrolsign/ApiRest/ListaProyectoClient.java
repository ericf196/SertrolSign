package com.example.ericfreitez.sertrolsign.ApiRest;

import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Eric Freitez on 17/05/2017.
 */

public class ListaProyectoClient implements Serializable {

    @SerializedName("encontrado")
    @Expose
    private Integer encontrado;

    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Integer encontrado) {
        this.encontrado = encontrado;
    }

    @SerializedName("proyectos")
    @Expose
    private List<Proyecto> proyectos = null;

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
