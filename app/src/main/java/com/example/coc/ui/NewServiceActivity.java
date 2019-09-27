package com.example.coc.ui;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

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

public class NewServiceActivity extends AppCompatActivity implements View.OnClickListener {

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
        EditTextEntradaRegisterService.setOnClickListener(this);

        EditTextSalidaRegisterService = findViewById(R.id.EditTextSalidaRegisterService);
        EditTextSalidaRegisterService.setOnClickListener(this);


        EditTextHoraEntrada = findViewById(R.id.EditTextHoraEntrada);
        EditTextHoraSalida = findViewById(R.id.EditTextHoraSalida);

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
            case R.id.EditTextEntradaRegisterService:
                showDatePickerDialog(EditTextEntradaRegisterService);
                break;

            case R.id.EditTextSalidaRegisterService:
                showDatePickerDialog(EditTextSalidaRegisterService);
                break;
        }

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
