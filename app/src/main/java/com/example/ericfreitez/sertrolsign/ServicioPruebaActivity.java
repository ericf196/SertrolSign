package com.example.ericfreitez.sertrolsign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.models.CatalogoProyecto;
import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.rest.ApiClient;
import com.example.ericfreitez.sertrolsign.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicioPruebaActivity extends AppCompatActivity {

    private static final String TAG = "Error Retrofit";
    TextView textservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_prueba);
        textservice= (TextView) findViewById(R.id.text_service);

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

        Call<CatalogoProyecto> requestCatalogos= service.listProyectos();

        requestCatalogos.enqueue(new Callback<CatalogoProyecto>() {
            @Override
            public void onResponse(Call<CatalogoProyecto> call, Response<CatalogoProyecto> response) {
                if (response.isSuccessful()){
                    Log.e(TAG, ""+ response.code());
                    Log.e(TAG,"onResponse Error: " + response.code() );

                }else{
                    CatalogoProyecto catalogo = response.body();
                    //textservice.setText(response.body().toString());
                    /*for (Proyecto p : catalogo.proyectos){
                        Log.e(TAG, p.);

                    }*/
                }
            }

            @Override
            public void onFailure(Call<CatalogoProyecto> call, Throwable t) {
                Log.e(TAG,"Error: " + t.getMessage() );
            }
        });
    }
}
