package com.example.coc.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.coc.R;

public class NewServiceActivity extends AppCompatActivity {

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

        nameService = (EditText) findViewById(R.id.nameService);
        descripcion = (EditText) findViewById(R.id.descripcion);
        nameEquipo = (EditText) findViewById(R.id.nameEquipo);
        serialEquipo = (EditText) findViewById(R.id.serialEquipo);
        horometro = (EditText) findViewById(R.id.horometro);
        EditTextEntradaRegisterService = (EditText) findViewById(R.id.EditTextEntradaRegisterService);
        EditTextSalidaRegisterService = (EditText) findViewById(R.id.EditTextSalidaRegisterService);
        EditTextHoraEntrada = (EditText) findViewById(R.id.EditTextHoraEntrada);
        EditTextHoraSalida = (EditText) findViewById(R.id.EditTextHoraSalida);

        CardView1 = (CardView) findViewById(R.id.CardView1);
        CardView2 = (CardView) findViewById(R.id.CardView2);
        CardView3 = (CardView) findViewById(R.id.CardView3);


        Button btn_siguiente_one = (Button) findViewById(R.id.btn_siguiente_one);
        Button btn_siguiente_two = (Button) findViewById(R.id.btn_siguiente_two);



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

        EditTextEntradaRegisterService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerEntrada();
            }
        });


    }



    private void datePickerEntrada() {

        getSupportFragmentManager();
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
