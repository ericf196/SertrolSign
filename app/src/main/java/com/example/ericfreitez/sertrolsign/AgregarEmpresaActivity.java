package com.example.ericfreitez.sertrolsign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarEmpresaActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText mTextNombre;
    private EditText mTextTelefono;
    private EditText mTextDireccion;
    private Button mBtnClearAll;
    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_empresa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mTextNombre= (EditText) findViewById(R.id.text_nombre);
        mTextTelefono= (EditText) findViewById(R.id.text_telefono);
        mTextDireccion= (EditText) findViewById(R.id.text_direccion);

        mBtnClearAll= (Button) findViewById(R.id.btn_clear_all);
        mBtnSend= (Button) findViewById(R.id.btn_send);

        mBtnSend.setOnClickListener(this);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_send:
                 Toast.makeText(this, "Funcionando", Toast.LENGTH_LONG).show();
                break;

        }
    }
}
