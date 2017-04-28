package com.example.ericfreitez.sertrolsign;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class AddFormProyectFragment extends Fragment implements  View.OnTouchListener{

    private TextView fechaForm;
    private EditText horaEntrada;
    private EditText horaSalida;
    /*private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;*/

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
        horaSalida= (EditText) v.findViewById(R.id.hora_salida);

        horaEntrada.setKeyListener(null);
        horaSalida.setKeyListener(null);
        horaEntrada.setText(getCurrentDate("horaAmPm"));
        fechaForm.setText(getCurrentDate("fecha"));

        horaEntrada.setOnTouchListener(this);
        horaSalida.setOnTouchListener(this);


        return v;


    }

    private void setDateTimeField() {

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                Log.i("msg",String.valueOf((String.valueOf(selectedHour)).length()));
                Log.i("msg",String.valueOf((String.valueOf(selectedMinute)).length()));

                int timehora=(String.valueOf(selectedHour)).length();
                int timeMinute=(String.valueOf(selectedMinute)).length();

                horaSalida.setText(timeTransform(timehora, timeMinute , selectedHour, selectedMinute));

            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Seleccione la hora");
        mTimePicker.show();

    }

    private String timeTransform(int timeHourLength, int timeMinuteLength ,int selectedHour, int selectedMinute){ // valida la hora en hora militar y llena de cero los espacios faltanes
        String timeReturn;

        if(timeMinuteLength==1|| timeMinuteLength==0 || timeHourLength==1 || timeHourLength==0 ) {

            String timeHoraReturn=String.valueOf(selectedHour);
            String timeMinuteReturn=String.valueOf(selectedMinute);

            if (timeMinuteLength == 1 || timeMinuteLength == 0) {
                timeMinuteReturn = ("0" + +selectedMinute);

            }
            if (timeHourLength == 1 || timeHourLength == 0) {
                timeHoraReturn = ("0" + selectedHour);
            }
            timeReturn = timeHoraReturn + ":" +timeMinuteReturn;

        }else
            timeReturn =( selectedHour + ":" + selectedMinute);

        return timeReturn;
    }

    private String getCurrentDate(String formato) {
        Calendar fecha = new GregorianCalendar();

        if(formato.equals("fecha")){

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i("msg","onTouch");

        if(event.getAction() == MotionEvent.ACTION_UP) {
            setDateTimeField();
        }

        return false;
    }

}
