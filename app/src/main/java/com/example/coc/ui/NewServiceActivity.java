package com.example.coc.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.coc.R;
import com.example.coc.common.DatePickerFragment;
import com.example.coc.common.TimePickerFragment;

public class NewServiceActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameService;
    EditText descripcion;
    EditText nameEquipo;
    EditText serialEquipo;
    EditText horometro;
    EditText fechaEntrada;
    EditText fechaSalida;
    EditText horaEntrada;
    EditText horaSalida;
    EditText plantaId;
    EditText clienteId;
    EditText fotoInicio;
    EditText fotoProceso;
    EditText fotoFin;




    CardView CardView1;
    CardView CardView2;
    CardView CardView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        nameService = findViewById(R.id.nombreServicio);
        descripcion = findViewById(R.id.descripcion);
        nameEquipo = findViewById(R.id.nombreEquipo);
        serialEquipo = findViewById(R.id.serialEquipo);
        horometro = findViewById(R.id.horometro);
        plantaId = findViewById(R.id.plantaId);
        clienteId = findViewById(R.id.clienteId);
        fotoInicio = findViewById(R.id.fotoInicio);
        fotoProceso = findViewById(R.id.fotoProceso);
        fotoFin = findViewById(R.id.fotoFin);

        fechaEntrada = findViewById(R.id.fechaEntrada);
        fechaEntrada.setOnClickListener(this);

        fechaSalida = findViewById(R.id.fechaSalida);
        fechaSalida.setOnClickListener(this);


        horaEntrada = findViewById(R.id.horaEntrada);
        horaEntrada.setOnClickListener(this);

        horaSalida = findViewById(R.id.horaSalida);
        horaSalida.setOnClickListener(this);

        CardView1 = findViewById(R.id.CardView1);
        CardView2 = findViewById(R.id.CardView2);
        CardView3 = findViewById(R.id.CardView3);


        Button btn_siguiente_one = findViewById(R.id.btn_siguiente_one);
        Button btn_siguiente_two = findViewById(R.id.btn_siguiente_two);
        Button btn_save = findViewById(R.id.btn_save_service);


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

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewServiceActivity.this, "Servicio guardado correctamente.", Toast.LENGTH_SHORT).show();
                finish();
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
                showDatePickerDialog(fechaEntrada);
                break;

            case R.id.fechaSalida:
                showDatePickerDialog(fechaSalida);
                break;

            case R.id.horaEntrada:
                showTimePickerDialog(horaEntrada);
                break;

            case R.id.horaSalida:
                showTimePickerDialog(horaSalida);
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

        if (nameService.getText().toString().isEmpty()) {
            nameService.setError("Debes ingresar el nombre del servicio.");
        }
        if (descripcion.getText().toString().isEmpty()) {
            descripcion.setError("Debes ingresar la descripción");
        }
        if (nameEquipo.getText().toString().isEmpty()) {
            nameEquipo.setError("Debes ingresar el nombre del equipo.");
        } else {


            CardView1.setVisibility(View.GONE);
            CardView2.setVisibility(View.VISIBLE);
            CardView3.setVisibility(View.GONE);
        }


    }


    private void validarCardTwo() {

        if (horaEntrada.getText().toString().isEmpty()) {
            nameEquipo.setError("Debes ingresar la hora inicial del servicio.");
        }
        if (fechaEntrada.getText().toString().isEmpty()) {
            descripcion.setError("Debes ingresar Fecha de inicial del servicio");
        } else {


            CardView1.setVisibility(View.GONE);
            CardView2.setVisibility(View.GONE);
            CardView3.setVisibility(View.VISIBLE);
        }
    }


}
