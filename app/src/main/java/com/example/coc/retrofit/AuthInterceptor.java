package com.example.coc.retrofit;


import com.example.coc.common.Constantes;
import com.example.coc.common.SharedPreferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        String token = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_TOKEN);
        String name = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_NAME);

        Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build();
        return chain.proceed(request);
    }

}
