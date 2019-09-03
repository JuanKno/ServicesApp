package com.example.coc.retrofit;

import com.example.coc.common.Constantes;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthApiClient {

    private static AuthApiClient instance = null;
    private AuthApiService apiService;
    private Retrofit retrofit;

    public AuthApiClient() {

        // inclución en la cabecera el token de autentificación

        OkHttpClient.Builder okHttpClienteBuilder = new OkHttpClient.Builder();
        okHttpClienteBuilder.addInterceptor(new AuthInterceptor());
        OkHttpClient cliente = okHttpClienteBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_COC_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        apiService = retrofit.create(AuthApiService.class);

    }

    //patrón Singleton
    public static AuthApiClient getInstance() {
        if (instance == null) {
            instance = new AuthApiClient();
        }
        return instance;
    }


    public AuthApiService getAuthApiService() {
        return apiService;
    }

}
