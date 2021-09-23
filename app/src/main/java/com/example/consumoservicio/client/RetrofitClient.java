package com.example.consumoservicio.client;

import com.example.consumoservicio.service.RetrofitApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String URL_Base = "https://private-83598-estudiantes.apiary-mock.com/";
    private static Retrofit retrofit;

    public static RetrofitApiService getApiService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(URL_Base)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit.create(RetrofitApiService.class);
    }
}
