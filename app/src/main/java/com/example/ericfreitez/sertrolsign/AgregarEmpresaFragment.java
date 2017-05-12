package com.example.ericfreitez.sertrolsign;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AgregarEmpresaFragment extends Fragment {

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

        return v;
    }


}
