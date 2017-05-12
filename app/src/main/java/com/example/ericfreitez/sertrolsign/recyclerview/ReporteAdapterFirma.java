package com.example.ericfreitez.sertrolsign.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.models.Proyecto;

import java.util.List;

/**
 * Created by Eric Freitez on 03/05/2017.
 */

public class ReporteAdapterFirma  extends RecyclerView.Adapter<ReporteAdapterFirma.ReporteFirmaViewHolder>{

    private List<Proyecto> itemsProyectos;

    public static class ReporteFirmaViewHolder extends RecyclerView.ViewHolder {

        public TextView reporteResponsable;
        public TextView reporteFecha;
        public TextView reporteDescripcion;

        public CardView card_view;


        public ReporteFirmaViewHolder(View v) {
            super(v);

            reporteResponsable = (TextView) v.findViewById( R.id.reporte_responsable);
            reporteFecha = (TextView) v.findViewById(R.id.reporte_fecha);
            reporteDescripcion = (TextView) v.findViewById(R.id.reporte_descripcion);
        }

    }

    public ReporteAdapterFirma(List<Proyecto> items) {
        this.itemsProyectos = items;
    }


    public ReporteFirmaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_reporte_servicio, parent, false);

        return new ReporteAdapterFirma.ReporteFirmaViewHolder(v);

    }

    public void onBindViewHolder(ReporteAdapterFirma.ReporteFirmaViewHolder holder, int position) {

        /*holder.reporteResponsable.setText(String.valueOf(itemsProyectos.get(position).getNombreResponsable()));
        holder.reporteFecha.setText(String.valueOf(itemsProyectos.get(position).getFechaProyecto()));
        holder.reporteDescripcion.setText(String.valueOf(itemsProyectos.get(position).getDescripcionProyecto()));*/

    }

    public int getItemCount() {
        return itemsProyectos.size();
    }
}
