package com.example.ericfreitez.sertrolsign.rest;

import com.example.ericfreitez.sertrolsign.models.CatalogoProyecto;
import com.example.ericfreitez.sertrolsign.models.Proyecto;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Eric Freitez on 12/05/2017.
 */

public interface ApiInterface {

    @GET("proyectouser/ericf196")
    Call<CatalogoProyecto> listProyectos();
}
