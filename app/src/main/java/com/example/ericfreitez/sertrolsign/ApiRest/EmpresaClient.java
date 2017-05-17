package com.example.ericfreitez.sertrolsign.ApiRest;

import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.MensajeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Eric Freitez on 16/05/2017.
 */

public interface EmpresaClient {

    @POST("insertarempresas")
    Call<MensajeResponse> createEmpresa(@Body Empresa empresa);

    @GET("empresas")
    Call<ListaEmpresaClient> getAllEmpresa();



}
