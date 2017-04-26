package com.example.ericfreitez.sertrolsign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFormProyectFragment extends Fragment {

    TextView fechaForm;
    EditText horaEntrada;
    EditText horaSalida;

    public static AddFormProyectFragment newInstance() {
        AddFormProyectFragment fragment = new AddFormProyectFragment();
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

        View v = inflater.inflate(R.layout.fragment_add_form_proyect, container, false);

        fechaForm= (TextView) v.findViewById(R.id.fecha_form);
        horaEntrada= (EditText) v.findViewById(R.id.hora_entrada);
        horaSalida= (EditText) v.findViewById(R.id.hora_Salida);
        horaEntrada.setKeyListener(null);
        horaSalida.setKeyListener(null);
        horaEntrada.setText(getCurrentDate("hora"));
        fechaForm.setText(getCurrentDate("fecha"));


        return v;
    }


    private String getCurrentDate(String formato) {
        Calendar fecha = new GregorianCalendar();

        if(formato=="fecha"){

        String year = String.valueOf(fecha.get(Calendar.YEAR));
        String month = String.valueOf(fecha.get(Calendar.MONTH));
        String day = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        if (month.length()==1) {
            month = "0" + month;
        }
        if (day.length()==1) {
            day = "0" + day;
        }
            String returnfecha=day + "/" + month +"/" + "" +year;
            return returnfecha;
        }else {
            String hora = String.valueOf(fecha.get(Calendar.HOUR));
            String minute = String.valueOf(fecha.get(Calendar.MINUTE));
            String returnHora=hora + ":" + minute;
            return returnHora;

        }




    }

}
