package com.example.ericfreitez.sertrolsign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ericfreitez.sertrolsign.models.CatalogoProyecto;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.rest.ApiClient;
import com.example.ericfreitez.sertrolsign.rest.ApiInterface;
import com.example.ericfreitez.sertrolsign.rest.EmpresaClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicioPruebaActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Error Retrofit";

    private TextView mTextNombre;
    private TextView mTextTelefono;
    private TextView mTextDireccion;
    private Button mbuttonInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_prueba);

        mTextNombre= (TextView) findViewById(R.id.text_nombre);
        mTextTelefono= (TextView) findViewById(R.id.text_telefono);
        mTextDireccion = (TextView) findViewById(R.id.text_direccion);

        mbuttonInsert= (Button) findViewById(R.id.button_insert);



        mbuttonInsert.setOnClickListener(this);


        /*ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

        Call<CatalogoProyecto> requestCatalogos= service.listProyectos();

        requestCatalogos.enqueue(new Callback<CatalogoProyecto>() {
            @Override
            public void onResponse(Call<CatalogoProyecto> call, Response<CatalogoProyecto> response) {
                if (!response.isSuccessful()){
                    Log.e(TAG, ""+ response.code());
                    Log.e(TAG,"onResponse :" + response.message());


                }else{
                    Log.e(TAG, ""+ response.code());
                    Log.e(TAG,"onResponse :" + response.message());
                    //CatalogoProyecto catalogo = response.body();
                    //textservice.setText(response.body().toString());
                    for (Proyecto p : catalogo.proyectos){
                        Log.e(TAG, String.format("%s : %s", p.CodigoProyecto, p.NombreProyecto));


                }
            }

            @Override
            public void onFailure(Call<CatalogoProyecto> call, Throwable t) {
                Log.e(TAG,"Error: " + t.getMessage() );
            }
        });*/
    }

    @Override
    public void onClick(View v) {

        Empresa empresa = new Empresa(
                mTextNombre.getText().toString(),
                mTextTelefono.getText().toString(),
                mTextDireccion.getText().toString()
        );

        //enviarInsert(empresa);

    }

    /*private void enviarInsert(Empresa empresa) {
        EmpresaClient service = ApiClient.getClient().create(EmpresaClient.class);

        Call<Empresa> call= service.createEmpresa(empresa);
        call.enqueue(new Callback<Empresa>() {
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                Log.i(TAG, "" + response.code());
                Toast.makeText(ServicioPruebaActivity.this, "Funcionando Bien" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                Toast.makeText(ServicioPruebaActivity.this, "Ahi Error", Toast.LENGTH_LONG).show();
            }
        });



    }*/
}
