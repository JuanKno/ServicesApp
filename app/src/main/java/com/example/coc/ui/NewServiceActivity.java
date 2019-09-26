package com.example.coc.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.coc.R;
import com.example.coc.common.DatePickerFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class NewServiceActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText nameService;
    EditText descripcion;
    EditText nameEquipo;
    EditText serialEquipo;
    EditText horometro;
    EditText EditTextEntradaRegisterService;
    EditText EditTextSalidaRegisterService;
    EditText EditTextHoraEntrada;
    EditText EditTextHoraSalida;
    CardView CardView1;
    CardView CardView2;
    CardView CardView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        nameService = findViewById(R.id.nameService);
        descripcion = findViewById(R.id.descripcion);
        nameEquipo = findViewById(R.id.nameEquipo);
        serialEquipo = findViewById(R.id.serialEquipo);
        horometro = findViewById(R.id.horometro);
        EditTextEntradaRegisterService = findViewById(R.id.EditTextEntradaRegisterService);
        EditTextSalidaRegisterService = findViewById(R.id.EditTextSalidaRegisterService);
        EditTextHoraEntrada = findViewById(R.id.EditTextHoraEntrada);
        EditTextHoraSalida = findViewById(R.id.EditTextHoraSalida);

        CardView1 = findViewById(R.id.CardView1);
        CardView2 = findViewById(R.id.CardView2);
        CardView3 = findViewById(R.id.CardView3);


        Button btn_siguiente_one = findViewById(R.id.btn_siguiente_one);
        Button btn_siguiente_two = findViewById(R.id.btn_siguiente_two);
        EditTextEntradaRegisterService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


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


    @Override
    public void onDateSet(DatePicker view, int year, int month, int datOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, datOfMonth);
        DateFormat dateFormat;
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        EditTextEntradaRegisterService.setText(currentDateString);

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

        if (EditTextHoraEntrada.getText().toString().isEmpty()) {
            nameEquipo.setError("Debes ingresar la hora inicial del servicio.");
        }
        if (EditTextEntradaRegisterService.getText().toString().isEmpty()) {
            descripcion.setError("Debes ingresar Fecha de inicial del servicio");
        } else {


            CardView1.setVisibility(View.GONE);
            CardView2.setVisibility(View.GONE);
            CardView3.setVisibility(View.VISIBLE);
        }
    }
}
