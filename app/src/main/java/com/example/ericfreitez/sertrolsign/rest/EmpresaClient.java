package com.example.ericfreitez.sertrolsign.rest;

import com.example.ericfreitez.sertrolsign.models.Empresa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Omega on 14/5/2017.
 */

public interface EmpresaClient {

    @POST("insertarempresas")
    Call<Empresa> createEmpresa(@Body  Empresa empresa);
}
