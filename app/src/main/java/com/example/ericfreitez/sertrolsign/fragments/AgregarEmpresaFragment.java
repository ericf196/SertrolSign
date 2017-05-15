package com.example.ericfreitez.sertrolsign.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.ServicioPruebaActivity;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.Mensaje;
import com.example.ericfreitez.sertrolsign.rest.ApiClient;
import com.example.ericfreitez.sertrolsign.rest.EmpresaClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AgregarEmpresaFragment extends Fragment implements View.OnClickListener{

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

        mBtnClearAll= (Button) v.findViewById(R.id.btn_clear_all);
        mBtnSend= (Button) v.findViewById(R.id.btn_send);

        mBtnSend.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_send:
                Empresa empresa = new Empresa(
                        mTextNombre.getText().toString(),
                        mTextTelefono.getText().toString(),
                        mTextDireccion.getText().toString()
                );


                enviarInsert(empresa);
                break;

        }
    }

    private void enviarInsert(Empresa empresa) {

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        EmpresaClient service = ApiClient.getClient().create(EmpresaClient.class);

        Call<Mensaje> call= service.createEmpresa(empresa);
        call.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {

                Log.i("msg", "" + response.body().getMensaje());

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
                Toast.makeText(getContext(), "" + response.body().getMensaje() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {

                Toast.makeText(getContext(), "Ahi Error", Toast.LENGTH_LONG).show();
            }
        });



    }
}
