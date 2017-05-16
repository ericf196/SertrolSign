package com.example.ericfreitez.sertrolsign;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.models.Empresa;

import java.util.ArrayList;
import java.util.List;


public class CrearProyectoFragment extends Fragment {

    EditText editNombreProyecto;
    Spinner spinner;
    EditText editDescripcionProyecto;

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


        editNombreProyecto = (EditText) v.findViewById(R.id.edit_nombre_proyecto);
        spinner = (Spinner) v.findViewById(R.id.spinner_empresa);
        editDescripcionProyecto = (EditText) v.findViewById(R.id.edit_descripcion_proyecto);


        //Empresa empresa = new Empresa();
        //ArrayList<Empresa> itemEmpresa = empresa.cargarData();
        //ArrayList<String> itemSpinner= new ArrayList<>();

        /*itemSpinner.add("Empresa");
        for (int i=0; i< empresa.cargarData().size(); i++){
            itemSpinner.add(itemEmpresa.get(i).getNombreEmpresa());
        }*/
        //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, itemSpinner);

        //spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(spinnerAdapter);

        return v;
    }

}
