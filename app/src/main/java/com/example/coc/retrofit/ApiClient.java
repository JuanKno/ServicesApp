package com.example.coc.retrofit;

import com.example.coc.common.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance = null;
    private ApiService apiService;
    private Retrofit retrofit;

    public ApiClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_COC_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

    }

    //patrón Singleton
    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }


    public ApiService getApiService() {
        return apiService;
    }

}
