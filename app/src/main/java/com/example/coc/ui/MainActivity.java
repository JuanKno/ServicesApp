package com.example.coc.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coc.R;
import com.example.coc.retrofit.ApiClient;
import com.example.coc.retrofit.ApiService;
import com.example.coc.retrofit.Request.RequestLogin;
import com.example.coc.retrofit.Response.ResponseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText etEmail, etPassword;
    ApiClient apiClient;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        apiClient = ApiClient.getInstance();
        apiService = apiClient.getApiService();
    }

    private void findViews() {

        btnLogin = findViewById(R.id.buttonLogin);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
    }


    private void events() {
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.buttonLogin:
                goToLogin();
                break;
        }

    }

    private void goToLogin() {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("El email es requerido");

        } else if (password.isEmpty()) {
            etPassword.setError("La contraseña es requerida");

        } else {
            RequestLogin requestLogin = new RequestLogin(email, password);

            Call<ResponseAuth> call = apiService.doLogin(requestLogin);
            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {

                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Sesion Iniciada correctamente.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(MainActivity.this, "Ha ocurrido un problema al iniciar sesión, Reviza tus credenciales.", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Problemas de conexión, Inténtelo nuevamente.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
