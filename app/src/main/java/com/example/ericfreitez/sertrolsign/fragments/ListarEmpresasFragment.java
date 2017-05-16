package com.example.ericfreitez.sertrolsign.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ericfreitez.sertrolsign.ApiRest.ApiClient;
import com.example.ericfreitez.sertrolsign.ApiRest.EmpresaClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ListaEmpresaClient;
import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.recyclerview.EmpresaAdapterListar;
import com.example.ericfreitez.sertrolsign.recyclerview.ProyectosAdapterPendientes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarEmpresasFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Empresa> empresas= new ArrayList<>() ;
    private ProgressDialog mProgressDialog;

    public ListarEmpresasFragment() {
        // Required empty public constructor
    }

    public static ListarEmpresasFragment newInstance() {
        ListarEmpresasFragment fragment = new ListarEmpresasFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_listar_empresas, container, false);

        cargarListaRetrofit();

        recycler = (RecyclerView) v.findViewById(R.id.recycler_empresas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());

        recycler.setLayoutManager(lManager);
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
                    ListaEmpresaClient listaEmpresa = response.body();
                    if (listaEmpresa!=null){
                        empresas= listaEmpresa.getEmpresas();
                        //Log.i("msg", ""+ empresas.size());
                        adapter = new EmpresaAdapterListar(empresas);
                        recycler.setAdapter(adapter);
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
