package com.example.ericfreitez.sertrolsign.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Eric Freitez on 16/05/2017.
 */

public class MensajeResponse {

    @SerializedName("Mensaje")
    @Expose
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
