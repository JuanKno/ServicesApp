package com.example.coc.data;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coc.common.MyApp;
import com.example.coc.retrofit.AuthApiClient;
import com.example.coc.retrofit.AuthApiService;
import com.example.coc.retrofit.Request.RequestCreateService;
import com.example.coc.retrofit.Response.Servicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceRepository {


    AuthApiService authApiService;
    AuthApiClient authApiClient;
    LiveData<List<Servicio>> allServices;

    ServiceRepository() {
        authApiClient = AuthApiClient.getInstance();
        authApiService = authApiClient.getAuthApiService();
        allServices = getAllServices();


    }

    public LiveData<List<Servicio>> getAllServices() {
        final MutableLiveData<List<Servicio>> data = new MutableLiveData<>();

        Call<List<Servicio>> call = authApiService.getAllServices();
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {

                if (response.isSuccessful()) {

                    data.setValue(response.body());


                } else {
                    Toast.makeText(MyApp.geContext(), "Ha ocurrido un error inesperado", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Toast.makeText(MyApp.geContext(), "Error en la conexión.", Toast.LENGTH_SHORT).show();

            }
        });

        return data;


    }


}

