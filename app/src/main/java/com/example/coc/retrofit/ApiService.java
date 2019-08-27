package com.example.coc.retrofit;

import com.example.coc.retrofit.Request.RequestLogin;
import com.example.coc.retrofit.Response.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<ResponseAuth> doLogin(@Body RequestLogin requestLogin);
}
