package com.example.appandroid.remote;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import dagger.Module;

@Module
public class ApiConexion {

    @Provides
    public Retrofit providerRetrofit(){
        return  new Retrofit.Builder().
                baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public ApiService provideApoiService(Retrofit retrofit){
        return  retrofit.create(ApiService.class);
    }
}
