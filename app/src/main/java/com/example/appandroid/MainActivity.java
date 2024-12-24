package com.example.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appandroid.adapter.WeathermapAdapter;
import com.example.appandroid.databinding.ActivityMainBinding;
import com.example.appandroid.di.AppComponet;
import com.example.appandroid.di.DaggerAppComponet;
import com.example.appandroid.model.Weathermap;
import com.example.appandroid.viewModel.WeathermapViewmodel;

import java.util.List;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private WeathermapViewmodel weathermapViewmodel;

    private WeathermapAdapter weathermapAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciudad  = binding.buscarCiudad.getText().toString();
                if(ciudad.isEmpty()){
                   Toast.makeText(getApplicationContext(),"Ingrese el nombre de una ciudad",Toast.LENGTH_LONG).show();
                   return;
                }

                AppComponet appComponet = DaggerAppComponet.create();
                appComponet.inject(MainActivity.this);


                binding.recyclerWeatherMap.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                weathermapViewmodel = new WeathermapViewmodel(appComponet.provideApoiService(),ciudad);

                obtenerdato(ciudad);


            }
        });


    }

    private void obtenerdato(String ciudad) {

        weathermapViewmodel.getWeathermap(ciudad).observe(this, new Observer<Weathermap>() {
            @Override
            public void onChanged(Weathermap weathermap) {
                Log.v("weathermap",weathermap.getName());
                if(weathermap!= null){
                    weathermapAdapter = new WeathermapAdapter(List.of(weathermap));
                    binding.recyclerWeatherMap.setAdapter(weathermapAdapter);
                }else{
                    Toast.makeText(getApplicationContext(), "No se encontraron resultados", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
