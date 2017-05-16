package com.example.ericfreitez.sertrolsign.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ericfreitez.sertrolsign.ApiRest.ApiClient;
import com.example.ericfreitez.sertrolsign.ApiRest.EmpresaClient;
import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.MensajeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AgregarEmpresaFragment extends Fragment implements View.OnClickListener, View.OnKeyListener{

    private EditText mTextNombre;
    private EditText mTextTelefono;
    private EditText mTextDireccion;
    private Button mBtnClearAll;
    private Button mBtnSend;
    private ProgressDialog mProgressDialog;

    public static AgregarEmpresaFragment newInstance() {
        AgregarEmpresaFragment fragment = new AgregarEmpresaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_agregar_empresa, container, false);

        mTextNombre= (EditText) v.findViewById(R.id.text_nombre);
        mTextTelefono= (EditText) v.findViewById(R.id.text_telefono);
        mTextDireccion= (EditText) v.findViewById(R.id.text_direccion);

        mTextNombre.setOnKeyListener(this);
        mTextTelefono.setOnKeyListener(this);
        mTextDireccion.setOnKeyListener(this);

        mBtnClearAll= (Button) v.findViewById(R.id.btn_clear_all);
        mBtnClearAll.setEnabled(false);

        mBtnSend= (Button) v.findViewById(R.id.btn_send);

        mBtnClearAll.setOnClickListener(this);
        mBtnSend.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_send:
                InsertarEmpresa();
                break;

            case R.id.btn_clear_all:
                LimpiarFormulario();
                break;
        }
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        String textNombre = mTextNombre.getText().toString();
        String textTelefono = mTextTelefono.getText().toString();
        String textDireccion = mTextDireccion.getText().toString();

        if (event.getAction() == MotionEvent.ACTION_UP){
            switch(v.getId()){

                case R.id.text_nombre:
                    Log.i("msg", "text_nombre");
                    if (!TextUtils.isEmpty(textNombre) || !TextUtils.isEmpty(textTelefono) || !TextUtils.isEmpty(textDireccion)) {
                        mBtnClearAll.setEnabled(true);
                    }else
                        mBtnClearAll.setEnabled(false);
                    break;
                case R.id.text_telefono:
                    Log.i("msg", "text_telefono");
                    if (!TextUtils.isEmpty(textNombre) || !TextUtils.isEmpty(textTelefono) || !TextUtils.isEmpty(textDireccion)) {
                        mBtnClearAll.setEnabled(true);
                    }else
                        mBtnClearAll.setEnabled(false);
                    break;

                case R.id.text_direccion:
                    Log.i("msg", "text_direccion");
                    if (!TextUtils.isEmpty(textNombre) || !TextUtils.isEmpty(textTelefono) || !TextUtils.isEmpty(textDireccion)) {
                        mBtnClearAll.setEnabled(true);
                    }else
                        mBtnClearAll.setEnabled(false);
                    break;

            }
        }
        /*if (event.getAction() == MotionEvent.ACTION_DOWN) {

        }*/
        return false;
    }

    private void LimpiarFormulario() {

        mTextNombre.setText("");
        mTextTelefono.setText("");
        mTextDireccion.setText("");

    }

    private void InsertarEmpresa() {

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        Empresa empresa = new Empresa(
                mTextNombre.getText().toString(),
                mTextTelefono.getText().toString(),
                mTextDireccion.getText().toString()
        );

        EmpresaClient service = ApiClient.getClient().create(EmpresaClient.class);

        Call<MensajeResponse> call= service.createEmpresa(empresa);
        call.enqueue(new Callback<MensajeResponse>() {
            @Override
            public void onResponse(Call<MensajeResponse> call, Response<MensajeResponse> response) {

                Log.i("msg", "" + response.body().getMensaje());

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
                Toast.makeText(getContext(), "" + response.body().getMensaje() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MensajeResponse> call, Throwable t) {

                Toast.makeText(getContext(), "Error onFailure Retrofit", Toast.LENGTH_LONG).show();
            }
        });


    }


}
