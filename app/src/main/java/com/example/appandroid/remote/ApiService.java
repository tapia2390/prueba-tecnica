package com.example.appandroid.remote;


import com.example.appandroid.model.Weathermap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("weather?lat=44.34&lon=10.99&appid=f7db53a4586d48d216c04f46b6137b76")
    Call<List<Weathermap>> getAllWeather();

   @GET("weather")
    Call<Weathermap> getWeathermapByCity(
            @Query("q") String city,
            @Query("appid")String apiKey
   );



}
