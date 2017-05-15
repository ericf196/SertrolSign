package com.example.ericfreitez.sertrolsign.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ericfreitez.sertrolsign.R;
import com.example.ericfreitez.sertrolsign.models.Empresa;

import java.util.List;

/**
 * Created by Eric Freitez on 04/05/2017.
 */

public class EmpresaAdapterListar extends RecyclerView.Adapter<EmpresaAdapterListar.EmpresaViewHolder>{

    private List<Empresa> itemsEmpresa;


    public static class EmpresaViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreEmpresa;
        public TextView direccionEmpresa;

        public EmpresaViewHolder(View v) {
            super(v);

            nombreEmpresa = (TextView) v.findViewById( R.id.nombre_empresa);
            direccionEmpresa = (TextView) v.findViewById(R.id.direccion_empresa);

        }
    }

    public EmpresaAdapterListar(List<Empresa> items) {
        this.itemsEmpresa = items;
    }



    public EmpresaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_empresa, parent, false);
        Log.i("msg", String.valueOf(v.getContext()));

        return new EmpresaViewHolder(v);

    }


    public void onBindViewHolder(EmpresaAdapterListar.EmpresaViewHolder holder, int position) {

        //holder.nombreEmpresa.setText(String.valueOf(itemsEmpresa.get(position).getNombreEmpresa()));
        //holder.direccionEmpresa.setText(String.valueOf(itemsEmpresa.get(position).getDireccionEmpresa()));

    }

    public int getItemCount() {
        return itemsEmpresa.size();
    }
}
