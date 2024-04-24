package com.example.ramadhan.api;

import com.example.ramadhan.model.ModelJadwal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("surakarta.json")
    Call<ModelJadwal> getJadwal();
}
