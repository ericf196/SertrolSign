package com.example.ericfreitez.sertrolsign.ApiRest;

import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.MensajeResponse;
import com.example.ericfreitez.sertrolsign.models.Proyecto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Eric Freitez on 16/05/2017.
 */

public interface ProyectoClient {

    @POST("loginprueba/{userName}/{password}")
    Call<ListaProyectoClient> Login(@Path("userName") String userName, @Path("password") String password);

    @GET("proyectouser/{userName}")
    Call<ListaProyectoClient> getProyectoUser(@Path("userName") String userName);

    @POST("insertarproyectos/{userName}")
    Call<MensajeResponse> createProyecto(@Path("userName") String userName ,@Body Proyecto proyecto);

}
