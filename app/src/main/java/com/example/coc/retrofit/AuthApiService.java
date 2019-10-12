package com.example.coc.retrofit;

import com.example.coc.retrofit.Request.RequestCreateService;
import com.example.coc.retrofit.Response.Servicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthApiService {

    @GET("servicio")
    Call<List<Servicio>> getAllServices();

    @POST("servicio")
    Call<Servicio> createService(@Body RequestCreateService requestCreateService);
}
