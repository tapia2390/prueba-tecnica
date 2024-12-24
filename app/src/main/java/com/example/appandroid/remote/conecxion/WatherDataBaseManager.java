package com.example.appandroid.remote.conecxion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WatherDataBaseManager {

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public WatherDataBaseManager(Context context){
        dbHelper = new SQLiteOpenHelper(context);
    }


    public void open(){
        database = dbHelper.getWritableDatabase();
    }


    public void close(){
        dbHelper.close();
    }

    public long insertMain(Double temp, Double feels_like, Double temp_min, Double temp_max, Integer pressure, Integer humidity, Integer sea_level, Integer grnd_level){
        ContentValues values = new ContentValues();
        values.put(SQLiteOpenHelper.tblMain_temp,temp);
        values.put(SQLiteOpenHelper.tblMain_feels_like,feels_like);
        values.put(SQLiteOpenHelper.tblMain_temp_min,temp_min);
        values.put(SQLiteOpenHelper.tblMain_temp_max,temp_max);
        values.put(SQLiteOpenHelper.tblMain_pressure,pressure);
        values.put(SQLiteOpenHelper.tblMain_humidity,humidity);
        values.put(SQLiteOpenHelper.tblMain_sea_level,sea_level);
        values.put(SQLiteOpenHelper.tblMain_grnd_level,grnd_level);
        return database.insert(SQLiteOpenHelper.tblMain,null, values);
    }


    public Long insertCoord(Double lat, Double lon){
        ContentValues values = new ContentValues();
        values.put(SQLiteOpenHelper.tblCoord_lat,lat);
        values.put(SQLiteOpenHelper.tblCoord_lon,lon);
        return database.insert(SQLiteOpenHelper.tblCoord,null, values);

    }


    public Long insertWeather(Integer id, String main, String description, String icon){
        ContentValues values = new ContentValues();
        values.put(SQLiteOpenHelper.tblWeather_main,main);
        values.put(SQLiteOpenHelper.tblWeather_description,description);
        values.put(SQLiteOpenHelper.tblWeather_icon,icon);
        return database.insert(SQLiteOpenHelper.tblWeather,null, values);
    }
}
