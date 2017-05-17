package com.example.ericfreitez.sertrolsign.ApiRest;

import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Eric Freitez on 16/05/2017.
 */

public interface ProyectoClient {

    @POST("loginprueba/{userName}/{password}")
    Call<ListaProyectoClient> Login(@Body User user);

}
