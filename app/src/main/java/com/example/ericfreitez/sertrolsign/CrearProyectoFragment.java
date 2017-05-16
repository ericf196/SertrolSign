package com.example.ericfreitez.sertrolsign;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.ApiRest.ApiClient;
import com.example.ericfreitez.sertrolsign.ApiRest.EmpresaClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ListaEmpresaClient;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.recyclerview.EmpresaAdapterListar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CrearProyectoFragment extends Fragment {

    private EditText textNombre;
    private EditText textDescripcion;
    private TextView textViewFecha;
    private Button btnClearAll;
    private Button btnSend;
    private Spinner spinner;
    private List<Empresa> empresas= new ArrayList<>() ;
    private ProgressDialog mProgressDialog;
    private ArrayList<String> itemSpinner= new ArrayList<>();

    public static CrearProyectoFragment newInstance(String param1, String param2) {
        CrearProyectoFragment fragment = new CrearProyectoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_crear_proyecto, container, false);

        textNombre = (EditText) v.findViewById(R.id.text_nombre);
        textDescripcion = (EditText) v.findViewById(R.id.text_descripcion);
        textViewFecha= (TextView) v.findViewById(R.id.fecha_entrada);

        btnClearAll= (Button) v.findViewById(R.id.btn_clear_all);
        btnSend= (Button) v.findViewById(R.id.btn_send);

        spinner = (Spinner) v.findViewById(R.id.spinner_empresa);

        itemSpinner.add("Empresa");
        cargarListaRetrofit();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, itemSpinner);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        return v;
    }

    private void cargarListaRetrofit(){

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        EmpresaClient service = ApiClient.getClient().create(EmpresaClient.class);
        Call<ListaEmpresaClient> call= service.getAllEmpresa();

        call.enqueue(new Callback<ListaEmpresaClient>() {
            @Override
            public void onResponse(Call<ListaEmpresaClient> call, Response<ListaEmpresaClient> response) {

                if (!response.isSuccessful()) {
                    Log.e("msg", "onResponse :" + response.message());
                } else {
                    Log.e("msg", "onResponse :" + response.message());
                    ListaEmpresaClient listaEmpresa = response.body();
                    if (listaEmpresa!=null){
                        empresas= listaEmpresa.getEmpresas();
                        for (int i=0; i< empresas.size(); i++){
                            itemSpinner.add(empresas.get(i).getNombreEmpresa());
                        }
                        //Log.i("msg", ""+ empresas.size());
                    }else{
                        Log.e("msg", "No Tiene");
                    }
                }

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<ListaEmpresaClient> call, Throwable t) {
                Log.e("msg","Error: " + t.getMessage() );
            }
        });
    }

}
