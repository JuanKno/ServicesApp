package com.example.coc.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import com.example.coc.R;
import com.example.coc.common.Constantes;
import com.example.coc.common.DatePickerFragment;
import com.example.coc.common.SharedPreferencesManager;
import com.example.coc.common.TimePickerFragment;
import com.example.coc.data.ServiceViewModel;

public class NewServiceActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNombreServicio;
    EditText etDescripcion;
    EditText etNameEquipo;
    EditText etSerialEquipo;
    EditText etHorometro;
    EditText etFechaEntrada;
    EditText etFechaSalida;
    EditText etHoraEntrada;
    EditText etHoraSalida;
    EditText etPlantaId;
    EditText etClienteId;
    EditText etFotoInicio;
    EditText etFotoProceso;
    EditText etFotoFin;
    Button btn_save;
    ImageView ivAvatar;


    CardView CardView1;
    CardView CardView2;
    CardView CardView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        etNombreServicio = findViewById(R.id.nombreServicio);
        etDescripcion = findViewById(R.id.descripcion);
        etNameEquipo = findViewById(R.id.nombreEquipo);
        etSerialEquipo = findViewById(R.id.serialEquipo);
        etHorometro = findViewById(R.id.horometro);
        etPlantaId = findViewById(R.id.plantaId);
        etClienteId = findViewById(R.id.clienteId);
        etFotoInicio = findViewById(R.id.fotoInicio);
        etFotoProceso = findViewById(R.id.fotoProceso);
        etFotoFin = findViewById(R.id.fotoFin);

        etFechaEntrada = findViewById(R.id.fechaEntrada);
        etFechaEntrada.setOnClickListener(this);

        etFechaSalida = findViewById(R.id.fechaSalida);
        etFechaSalida.setOnClickListener(this);


        etHoraEntrada = findViewById(R.id.horaEntrada);
        etHoraEntrada.setOnClickListener(this);

        etHoraSalida = findViewById(R.id.horaSalida);
        etHoraSalida.setOnClickListener(this);

        btn_save = findViewById(R.id.btn_save_service);
        btn_save.setOnClickListener(this);


        //setear la imagen de perfil
        String fotoInicio = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_PHOTO);


        CardView1 = findViewById(R.id.CardView1);
        CardView2 = findViewById(R.id.CardView2);
        CardView3 = findViewById(R.id.CardView3);


        Button btn_siguiente_one = findViewById(R.id.btn_siguiente_one);
        Button btn_siguiente_two = findViewById(R.id.btn_siguiente_two);


        btn_siguiente_one.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                validarCardOne();
            }

        });

        btn_siguiente_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCardTwo();
            }
        });


    }


    private String twoDigits(int n) {
        return (n <= 9) ? ("0" + n) : String.valueOf(n);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.fechaEntrada:
                showDatePickerDialog(etFechaEntrada);
                break;

            case R.id.fechaSalida:
                showDatePickerDialog(etFechaSalida);
                break;

            case R.id.horaEntrada:
                showTimePickerDialog(etHoraEntrada);
                break;

            case R.id.horaSalida:
                showTimePickerDialog(etHoraSalida);
                break;

            case R.id.btn_save_service:
                String nombreServicio = etNombreServicio.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                String nombreEquipo = etNameEquipo.getText().toString();
                String serialEquipo = etSerialEquipo.getText().toString();
                String horometro = etHorometro.getText().toString();
                String fechaEntrada = etFechaEntrada.getText().toString();
                String fechaSalida = etFechaSalida.getText().toString();
                String horaEntrada = etHoraEntrada.getText().toString();
                String horaSalida = etHoraSalida.getText().toString();
                int plantaId = Integer.parseInt(etPlantaId.getText().toString());
                int clienteId = Integer.parseInt(etClienteId.getText().toString());
                String fotoInicio = etFotoInicio.getText().toString();
                String fotoProceso = etFotoProceso.getText().toString();
                String fotoFin = etFotoFin.getText().toString();


                ServiceViewModel serviceViewModel = ViewModelProviders.of(this).get(ServiceViewModel.class);
                serviceViewModel.insertService(nombreServicio, descripcion, nombreEquipo, serialEquipo, horometro, fechaEntrada, fechaSalida, horaEntrada, horaSalida, plantaId, clienteId, fotoInicio, fotoProceso, fotoFin);



                break;
        }

    }


    private void showTimePickerDialog(final EditText editText) {
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                final String selectTime = twoDigits(hour) + ":" + twoDigits(minute);
                editText.setText(selectTime);

            }
        });
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }


    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month + 1) + "/" + year;
                editText.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    private void validarCardOne() {

        if (etNombreServicio.getText().toString().isEmpty()) {
            etNombreServicio.setError("Debes ingresar el nombre del servicio.");
        }
        if (etDescripcion.getText().toString().isEmpty()) {
            etDescripcion.setError("Debes ingresar la descripción");
        }
        if (etNameEquipo.getText().toString().isEmpty()) {
            etNameEquipo.setError("Debes ingresar el nombre del equipo.");
        } else {


            CardView1.setVisibility(View.GONE);
            CardView2.setVisibility(View.VISIBLE);
            CardView3.setVisibility(View.GONE);
        }


    }


    private void validarCardTwo() {

        if (etHoraEntrada.getText().toString().isEmpty()) {
            etHoraEntrada.setError("Debes ingresar la hora inicial del servicio.");
        }
        if (etHoraSalida.getText().toString().isEmpty()) {
            etHoraSalida.setError("Debes ingresar hora de inicial del servicio");
        } else {


            CardView1.setVisibility(View.GONE);
            CardView2.setVisibility(View.GONE);
            CardView3.setVisibility(View.VISIBLE);
        }
    }


}
