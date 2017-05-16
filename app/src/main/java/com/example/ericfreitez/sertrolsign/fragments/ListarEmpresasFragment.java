package com.example.ericfreitez.sertrolsign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.recyclerview.EmpresaAdapterListar;
import com.example.ericfreitez.sertrolsign.recyclerview.ProyectosAdapterPendientes;

import java.util.ArrayList;


public class ListarEmpresasFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public ListarEmpresasFragment() {
        // Required empty public constructor
    }

    public static ListarEmpresasFragment newInstance() {
        ListarEmpresasFragment fragment = new ListarEmpresasFragment();

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
        View v=inflater.inflate(R.layout.fragment_listar_empresas, container, false);

        //Empresa empresa=new Empresa();
        //ArrayList<Empresa> itemsEmpresa;
        //itemsEmpresa=empresa.cargarData();

        // Obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.recycler_empresas);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity());

        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        //adapter = new EmpresaAdapterListar(itemsEmpresa);
        //recycler.setAdapter(adapter);

        return v;
    }

}
