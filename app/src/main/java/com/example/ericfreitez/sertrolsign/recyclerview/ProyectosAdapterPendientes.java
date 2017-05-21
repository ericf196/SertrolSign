package com.example.ericfreitez.sertrolsign.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.FirmaReporteActivity;
import com.example.ericfreitez.sertrolsign.MainActivity;
import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.ReporteServicioActivity;
import com.example.ericfreitez.sertrolsign.models.Proyecto;

import java.util.List;

/**
 * Created by Eric Freitez on 26/04/2017.
 */

public class ProyectosAdapterPendientes extends RecyclerView.Adapter<ProyectosAdapterPendientes.ProyectosViewHolder>{


    private List<Proyecto> itemsProyectos;
    public Context context;


    public static class ProyectosViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreEmpresa;
        public TextView nombreProyecto;
        public TextView direccionEmpresa;
        public TextView fechaProyecto;
        public Button opcionAgregarServicio;
        public Button opcionCerrarServicio;


        public ProyectosViewHolder(View v) {
            super(v);

            nombreEmpresa = (TextView) v.findViewById( R.id.nombre_empresa);
            nombreProyecto = (TextView) v.findViewById(R.id.nombre_proyecto);
            direccionEmpresa = (TextView) v.findViewById(R.id.direccion_empresa);
            fechaProyecto = (TextView) v.findViewById(R.id.fecha_proyecto);
            opcionAgregarServicio = (Button) v.findViewById(R.id.opcion_agregar_servicio);
            opcionCerrarServicio = (Button) v.findViewById(R.id.opcion_cerrar_servicio);

        }
    }

    public ProyectosAdapterPendientes(List<Proyecto> items) {
        this.itemsProyectos = items;
    }


    public ProyectosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_proyectos, parent, false);
        //Log.i("msg", String.valueOf(v.getContext()));
        context=v.getContext();

        return new ProyectosViewHolder(v);

    }


    public void onBindViewHolder(ProyectosViewHolder holder, int position) {

        holder.nombreEmpresa.setText(String.valueOf(itemsProyectos.get(position).getCodigoProyecto()));
        holder.nombreProyecto.setText(String.valueOf(itemsProyectos.get(position).getNombreProyecto()));
        holder.direccionEmpresa.setText(String.valueOf(itemsProyectos.get(position).getDescripcionProyecto()));
        holder.fechaProyecto.setText(String.valueOf(itemsProyectos.get(position).getNombreEmpresa()));

        /*metodoOpcionAgregarServicio(holder, position);
        metodoOpcionCerrarServicio(holder, position);*/

    }

    private void metodoOpcionAgregarServicio(ProyectosViewHolder holder,final int position) {
        holder.opcionAgregarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("msg","Ëscuchando"+ position);
                //Log.i("msg","opcionAgregarServicio " + position);
                Intent i = new Intent(context, ReporteServicioActivity.class);
                context.startActivity(i);

            }
        });

    }

    private void metodoOpcionCerrarServicio(ProyectosViewHolder holder, final int position) {

        holder.opcionCerrarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("msg","Ëscuchando"+ position);
                Log.i("msg","opcionCerrarServicio "+ position);
                Intent i = new Intent(context, FirmaReporteActivity.class);
                context.startActivity(i);

            }
        });


    }

    public int getItemCount() {
        return itemsProyectos.size();
    }


}
