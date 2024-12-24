package com.example.appandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.model.Weathermap;

import org.w3c.dom.Text;

import java.util.List;

public class WeathermapAdapter extends RecyclerView.Adapter<WeathermapAdapter.WeathermapViewHolder>{


    private List<Weathermap> weathermapList;


    public  WeathermapAdapter(List<Weathermap> weathermapList){
        this.weathermapList = weathermapList;
    }
    @NonNull
    @Override
    public WeathermapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
        return new WeathermapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeathermapViewHolder holder, int position) {
        Weathermap weathermap = weathermapList.get(position);
        holder.nombre.setText( "Nombre de la cidad: " +weathermap.getName() +"\n");
        holder.temperatura.setText("Temperatura: "+weathermap.getMain().getTemp()+"\n"

                + "Temperatura: "+weathermap.getMain().getHumidity()+"\n"
                + "Velocidad del viento: "+weathermap.getWind().getSpeed()+"\n"
        );
    }



    @Override
    public int getItemCount() {
        return weathermapList.size();
    }

    public static class WeathermapViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        TextView temperatura;


        public WeathermapViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(android.R.id.text1);
            temperatura = itemView.findViewById(android.R.id.text2);
        }
    }
}
