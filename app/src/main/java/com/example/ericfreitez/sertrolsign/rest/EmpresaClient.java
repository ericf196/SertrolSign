package com.example.ericfreitez.sertrolsign.rest;

import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.Mensaje;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Omega on 14/5/2017.
 */

public interface EmpresaClient {

    @POST("insertarempresas")
    Call<Mensaje> createEmpresa(@Body  Empresa empresa);




}
