package com.example.ericfreitez.sertrolsign;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.recyclerview.ProyectosAdapterPendientes;
import com.example.ericfreitez.sertrolsign.recyclerview.ReporteAdapterFirma;

import java.util.ArrayList;

public class FirmaReporteActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma_reporte);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


       /* Proyecto proyecto=new Proyecto();
        ArrayList<Proyecto> itemsProyectos;
        itemsProyectos=proyecto.cargarData();*/

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recycler_reporte_servicio);
        recycler.setHasFixedSize(true);
        recycler.requestFocus();

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        //adapter = new ReporteAdapterFirma(itemsProyectos);
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
