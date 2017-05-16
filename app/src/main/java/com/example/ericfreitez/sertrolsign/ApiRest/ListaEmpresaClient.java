package com.example.ericfreitez.sertrolsign.ApiRest;

import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Eric Freitez on 16/05/2017.
 */

public class ListaEmpresaClient {

    @SerializedName("empresas")
    @Expose
    private List<Empresa> empresas = null;

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
