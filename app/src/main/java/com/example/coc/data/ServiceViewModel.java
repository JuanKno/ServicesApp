package com.example.coc.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coc.retrofit.Response.Servicio;

import java.util.List;


public class ServiceViewModel extends AndroidViewModel {

    private ServiceRepository serviceRepository;
    private LiveData<List<Servicio>> servicios;


    public ServiceViewModel(@NonNull Application application) {
        super(application);
        serviceRepository = new ServiceRepository();
        servicios = serviceRepository.getAllServices();

    }

    public LiveData<List<Servicio>> getServicios() {
        return servicios;
    }
}
