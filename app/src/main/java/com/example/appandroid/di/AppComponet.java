package com.example.appandroid.di;

import com.example.appandroid.MainActivity;
import com.example.appandroid.remote.ApiConexion;
import com.example.appandroid.remote.ApiService;

import dagger.Component;

@Component(modules = ApiConexion.class)
public  interface AppComponet {
    ApiService provideApoiService();
    void inject(MainActivity mainActivity);

}