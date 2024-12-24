package com.example.appandroid.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.appandroid.model.Weathermap;
import com.example.appandroid.remote.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeathermapViewmodel {

    private MutableLiveData<List<Weathermap>> weathermapLiveData    = new MutableLiveData<>();


    private ApiService apiService;

    public WeathermapViewmodel(ApiService apiService,String ciudad) {
        this.apiService = apiService;

        obtenerdato(ciudad);
    }

    private final MutableLiveData<Weathermap> weathermap = new MutableLiveData<>();
    public LiveData<Weathermap>getWeathermap(String ciudad){
        return  weathermap;
    }



    private void obtenerdato(String ciudad) {

        String apiKey = "f7db53a4586d48d216c04f46b6137b76";
        apiService.getWeathermapByCity(ciudad,apiKey).enqueue(new Callback<Weathermap>() {
            @Override
            public void onResponse(Call<Weathermap> call, Response<Weathermap> response) {
                if(response.isSuccessful()){
                    weathermap.setValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<Weathermap> call, Throwable t) {

            }
        });   }

}
