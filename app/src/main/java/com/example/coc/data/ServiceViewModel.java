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


    public void insertService(String nombreServicio, String descripcion, String nombreEquipo, String serialEquipo, String horometro, String fechaEntrada, String fechaSalida,
                              String horaEntrada, String horaSalida, int plantaId, int clienteId, String fotoInicio, String fotoProceso, String fotoFin) {


        serviceRepository.createService(nombreServicio, descripcion, nombreEquipo, serialEquipo, horometro, fechaEntrada, fechaSalida, horaEntrada, horaSalida, plantaId, clienteId, fotoInicio, fotoProceso, fotoFin);
    }

}
