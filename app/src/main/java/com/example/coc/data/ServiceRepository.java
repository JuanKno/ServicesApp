package com.example.coc.data;

import android.app.Service;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coc.common.MyApp;
import com.example.coc.retrofit.AuthApiClient;
import com.example.coc.retrofit.AuthApiService;
import com.example.coc.retrofit.Request.RequestCreateService;
import com.example.coc.retrofit.Response.Servicio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceRepository {


    AuthApiService authApiService;
    AuthApiClient authApiClient;
    MutableLiveData<List<Servicio>> allServices;

    ServiceRepository() {
        authApiClient = AuthApiClient.getInstance();
        authApiService = authApiClient.getAuthApiService();
        allServices = getAllServices();


    }

    public MutableLiveData<List<Servicio>> getAllServices() {

        if (allServices == null) {
            allServices = new MutableLiveData<>();
        }

        Call<List<Servicio>> call = authApiService.getAllServices();
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {

                if (response.isSuccessful()) {

                    allServices.setValue(response.body());


                } else {
                    Toast.makeText(MyApp.geContext(), "Ha ocurrido un error inesperado", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Toast.makeText(MyApp.geContext(), "Error en la conexión.", Toast.LENGTH_SHORT).show();

            }
        });

        return allServices;


    }

    public void createService(String nombreServicio, String descripcion, String nombreEquipo, String serialEquipo, String horometro, String fechaEntrada, String fechaSalida,
                              String horaEntrada, String horaSalida, int plantaId, int clienteId, String fotoInicio, String fotoProceso, String fotoFin) {

        RequestCreateService request = new RequestCreateService(nombreServicio, descripcion, nombreEquipo, serialEquipo, horometro, fechaEntrada, fechaSalida, horaEntrada, horaSalida, plantaId, clienteId, fotoInicio, fotoProceso, fotoFin);
        Call<Servicio> call = authApiService.createService(request);

        call.enqueue(new Callback<Servicio>() {
            @Override
            public void onResponse(Call<Servicio> call, Response<Servicio> response) {
                if (response.isSuccessful()) {

                    List<Servicio> listaClonada = new ArrayList<>();
                    listaClonada.add(response.body());

                    for (int i = 0; i < allServices.getValue().size(); i++) {

                        listaClonada.add(new Servicio(allServices.getValue().get(i)));

                    }

                    allServices.setValue(listaClonada);


                } else {
                    Toast.makeText(MyApp.geContext(), "Ha ocurrido un error, intentelo nuevamente.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Servicio> call, Throwable t) {
                Toast.makeText(MyApp.geContext(), "Error en la conexión, intentelo nuevamente", Toast.LENGTH_SHORT).show();

            }
        });
    }


}

