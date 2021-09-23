package com.example.consumoservicio.service;

import java.util.List;

import  com.example.consumoservicio.entity.Estudiante;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {

    @GET("estudiantes")
    Call<List<Estudiante>> getEstudiantes();
}
