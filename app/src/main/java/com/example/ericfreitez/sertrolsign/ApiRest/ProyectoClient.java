package com.example.ericfreitez.sertrolsign.ApiRest;

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

    //@POST("/SF_UserLogin.svc/rest/login/{employeeCode}/{password}") // Assume your base url is http://172.16.7.203/sfAppServices/
    //public Call<LoginResponseDto> login(@Path("employeeCode") String employeeCode, @Path("password") String password);

}
