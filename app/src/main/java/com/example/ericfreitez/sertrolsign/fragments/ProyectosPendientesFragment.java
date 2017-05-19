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
import com.example.ericfreitez.sertrolsign.ApiRest.ListaProyectoClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ProyectoClient;
import com.example.ericfreitez.sertrolsign.MainActivity;
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

public class ProyectosPendientesFragment extends Fragment {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Proyecto> proyectos= new ArrayList<>() ;
    private ProgressDialog mProgressDialog;
    private String userName;
    private MainActivity activity;
    private View emptyStateContainer;


    public static ProyectosPendientesFragment newInstance() {
        ProyectosPendientesFragment fragment = new ProyectosPendientesFragment();

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
        View v= inflater.inflate(R.layout.fragment_proyectos_pendientes, container, false);

        emptyStateContainer= v.findViewById(R.id.empty_state_container);

        activity = (MainActivity) getActivity();
        userName = activity.getMyData();

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.recycler_proyectos_pendientes);
        recycler.setHasFixedSize(true);

        cargarListaProyectosRetrofit();
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());

        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        //adapter = new ProyectosAdapterPendientes(itemsProyectos);
        recycler.setAdapter(adapter);


        return v;
    }

    private void cargarListaProyectosRetrofit(){

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        ProyectoClient service = ApiClient.getClient().create(ProyectoClient.class);

        Call<ListaProyectoClient> call= service.getProyectoUser(userName);

        call.enqueue(new Callback<ListaProyectoClient>() {
            @Override
            public void onResponse(Call<ListaProyectoClient> call, Response<ListaProyectoClient> response) {

                    ListaProyectoClient listaProyectoUser = response.body();
                    if (listaProyectoUser!=null){
                        proyectos= listaProyectoUser.getProyectos();
                        adapter = new ProyectosAdapterPendientes(proyectos);
                        recycler.setAdapter(adapter);
                        showBackgroundEmpty(listaProyectoUser);
                    }

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<ListaProyectoClient> call, Throwable t) {
                Log.e("msg","Error: " + t.getMessage() );
            }
        });

    }

    private void showBackgroundEmpty(ListaProyectoClient listaProyectoUser) {

        if(listaProyectoUser.getMensaje().equals("El usuario no tiene proyectos asociados")){
            recycler.setVisibility(View.GONE);
        }else if(listaProyectoUser.getMensaje().equals("El usuario tiene proyectos asociados")) {
            emptyStateContainer.setVisibility(View.GONE);
        }
    }
}
