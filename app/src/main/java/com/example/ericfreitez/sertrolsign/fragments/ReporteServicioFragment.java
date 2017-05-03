package com.example.ericfreitez.sertrolsign.fragments;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toolbar;

import com.example.ericfreitez.sertrolsign.R;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ReporteServicioFragment extends Fragment implements  View.OnTouchListener, SeekBar.OnSeekBarChangeListener,View.OnClickListener{

    private TextView fechaEntrada;
    private TextView fechaSalida;
    private TextView editResponsableEmpresa;

    private EditText horaEntrada;
    private EditText horaSalida;

    private CheckBox checkBoxHorasNormales;
    private CheckBox checkBoxHorasExtrasDiaurnas;
    private CheckBox checkBoxHorasExtrasNocturnas;
    private CheckBox checkBoxHorasFeriados;
    private CheckBox checkBoxHorasViajes;

    private SeekBar seekBarOne;
    private SeekBar seekBarTwo;
    private SeekBar seekBarThree;
    private SeekBar seekBarFour;
    private SeekBar seekBarFive;

    private LinearLayout oneRow;
    private LinearLayout twoRow;
    private LinearLayout threeRow;
    private LinearLayout fourRow;
    private LinearLayout fiveRow;

    private TextView textSeekBarQuantityOne;
    private TextView textSeekBarQuantityTwo;
    private TextView textSeekBarQuantityThree;
    private TextView textSeekBarQuantityFour;
    private TextView textSeekBarQuantityFive;

    public static ReporteServicioFragment newInstance() {
        ReporteServicioFragment fragment = new ReporteServicioFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_reporte_servicio, container, false);

        fechaEntrada= (TextView) v.findViewById(R.id.fecha_entrada);
        fechaSalida= (TextView) v.findViewById(R.id.fecha_salida);
        editResponsableEmpresa= (TextView) v.findViewById(R.id.edit_responsable_empresa);
        editResponsableEmpresa= (TextView) v.findViewById(R.id.edit_responsable_empresa);


        horaEntrada= (EditText) v.findViewById(R.id.hora_entrada);
        horaSalida= (EditText) v.findViewById(R.id.hora_salida);
        horaSalida= (EditText) v.findViewById(R.id.hora_salida);

        seekBarOne= (SeekBar) v.findViewById(R.id.seek_bar_one);
        seekBarTwo= (SeekBar) v.findViewById(R.id.seek_bar_two);
        seekBarThree= (SeekBar) v.findViewById(R.id.seek_bar_three);
        seekBarFour= (SeekBar) v.findViewById(R.id.seek_bar_four);
        seekBarFive= (SeekBar) v.findViewById(R.id.seek_bar_five);

        //Setea  el setMax, setProgress y setOnSeekBarChangeListener
        setSeekBar(seekBarOne);
        setSeekBar(seekBarTwo);
        setSeekBar(seekBarThree);
        setSeekBar(seekBarFour);
        setSeekBar(seekBarFive);

        //checkbox
        checkBoxHorasNormales= (CheckBox) v.findViewById(R.id.check_box_horas_normales);
        checkBoxHorasNormales.requestFocus();
        checkBoxHorasExtrasDiaurnas= (CheckBox) v.findViewById(R.id.check_box_horas_extras_diaurnas);
        checkBoxHorasExtrasNocturnas= (CheckBox) v.findViewById(R.id.check_box_horas_extras_nocturnas);
        checkBoxHorasFeriados= (CheckBox) v.findViewById(R.id.check_box_horas_feriados);
        checkBoxHorasViajes= (CheckBox) v.findViewById(R.id.check_box_horas_viajes);

        //OnClickListener checkbox
        checkBoxHorasExtrasDiaurnas.setOnClickListener(this);
        checkBoxHorasExtrasDiaurnas.setOnClickListener(this);
        checkBoxHorasNormales.setOnClickListener(this);
        checkBoxHorasFeriados.setOnClickListener(this);
        checkBoxHorasExtrasNocturnas.setOnClickListener(this);
        checkBoxHorasViajes.setOnClickListener(this);


        //linears
        oneRow= (LinearLayout) v.findViewById(R.id.one_row);
        twoRow= (LinearLayout) v.findViewById(R.id.two_row);
        threeRow= (LinearLayout) v.findViewById(R.id.three_row);
        fourRow= (LinearLayout) v.findViewById(R.id.four_row);
        fiveRow= (LinearLayout) v.findViewById(R.id.five_row);

        //TextView seekBar cantidad horas
        textSeekBarQuantityOne= (TextView) v.findViewById(R.id.seek_bar_cantidad_horas_one);
        textSeekBarQuantityTwo= (TextView) v.findViewById(R.id.seek_bar_cantidad_horas_two);
        textSeekBarQuantityThree= (TextView) v.findViewById(R.id.seek_bar_cantidad_horas_three);
        textSeekBarQuantityFour= (TextView) v.findViewById(R.id.seek_bar_cantidad_horas_four);
        textSeekBarQuantityFive= (TextView) v.findViewById(R.id.seek_bar_cantidad_horas_five);


        //linear View.Gone
        oneRow.setVisibility(View.GONE);
        twoRow.setVisibility(View.GONE);
        threeRow.setVisibility(View.GONE);
        fourRow.setVisibility(View.GONE);
        fiveRow.setVisibility(View.GONE);

        // No permiten escritura EditText hora entrada Salida
        horaEntrada.setKeyListener(null);
        horaSalida.setKeyListener(null);


        horaEntrada.setText(getCurrentDate("horaAmPm"));

        fechaEntrada.setText(getCurrentDate());
        fechaSalida.setText(getCurrentDate());

        horaEntrada.setOnTouchListener(this);
        horaSalida.setOnTouchListener(this);


        return v;

    }

    private void setSeekBar(SeekBar s) {
        s.setMax(24);
        s.setProgress(0);
        s.setOnSeekBarChangeListener(this);

    }

    private void setDateTimeField(final View v) {

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                //Log.i("msg",String.valueOf((String.valueOf(selectedHour)).length()));
                //Log.i("msg",String.valueOf((String.valueOf(selectedMinute)).length()));

                int timehora=(String.valueOf(selectedHour)).length();
                int timeMinute=(String.valueOf(selectedMinute)).length();


                if (v.getId() == R.id.hora_entrada)
                    horaEntrada.setText(timeTransform(timehora, timeMinute , selectedHour, selectedMinute));
                else
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

    private String getCurrentDate() {
        Calendar fecha = new GregorianCalendar();

        String year = String.valueOf(fecha.get(Calendar.YEAR));
        String month = String.valueOf(fecha.get(Calendar.MONTH));
        String day = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));

        if (month.length()==1) {
            month = "0" + month;
           }

        if (day.length()==1) {
            day = "0" + day;
            }

        String returnfecha = day + "/" + month + "/" +year;

        return returnfecha;

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


        if (event.getAction() == MotionEvent.ACTION_UP) {

                switch(v.getId()){

                    case R.id.hora_entrada:
                            setDateTimeField(v);
                        break;

                    case R.id.hora_salida:
                            setDateTimeField(v);
                        break;

                }
        }
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch(seekBar.getId()){

            case R.id.seek_bar_one:
                textSeekBarQuantityOne.setText(String.valueOf(progress*0.5));
                break;

            case R.id.seek_bar_two:
                textSeekBarQuantityTwo.setText(String.valueOf(progress*0.5));
                break;

            case R.id.seek_bar_three:
                textSeekBarQuantityThree.setText(String.valueOf(progress*0.5));
                break;

            case R.id.seek_bar_four:
                textSeekBarQuantityFour.setText(String.valueOf(progress*0.5));
                break;

            case R.id.seek_bar_five:
                textSeekBarQuantityFive.setText(String.valueOf(progress*0.5));
                break;

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.check_box_horas_extras_diaurnas:

                if(checkBoxHorasExtrasDiaurnas.isChecked())
                    oneRow.setVisibility(View.VISIBLE);
                else
                    oneRow.setVisibility(View.GONE);
                break;

            case R.id.check_box_horas_normales:
                if(checkBoxHorasNormales.isChecked())
                    twoRow.setVisibility(View.VISIBLE);
                else
                    twoRow.setVisibility(View.GONE);
                break;

            case R.id.check_box_horas_feriados:
                if(checkBoxHorasFeriados.isChecked())
                    threeRow.setVisibility(View.VISIBLE);
                else
                    threeRow.setVisibility(View.GONE);
                break;

            case R.id.check_box_horas_extras_nocturnas:
                if(checkBoxHorasExtrasNocturnas.isChecked())
                    fourRow.setVisibility(View.VISIBLE);
                else
                    fourRow.setVisibility(View.GONE);
                break;

            case R.id.check_box_horas_viajes:
                if(checkBoxHorasViajes.isChecked())
                    fiveRow.setVisibility(View.VISIBLE);
                else
                    fiveRow.setVisibility(View.GONE);
                break;


        }

    }
}
