package com.example.appandroid.remote.conecxion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public   static final  String DataBaseName = "WeathermapBd";
    public  static final  int  DataBaseVersion = 1;

    public  static final  String tblMain= "main";

    public  static final  String tblMain_id = "id" ;
    public  static final  String tblMain_temp = "tem" ;
    public  static final   String tblMain_feels_like = "feels_like" ;
    public  static final   String tblMain_temp_min = "temp_min" ;
    public  static final   String tblMain_temp_max = "temp_max" ;
    public  static final   String tblMain_pressure = "pressure" ;
    public  static final   String tblMain_humidity = "humidity" ;
    public  static final   String tblMain_sea_level= "sea_level" ;
    public  static final   String tblMain_grnd_level = "grnd_level" ;



    public  static final  String tblWeather= "weather";

    public  static final  String tblWeather_id ="id" ;
    public  static final  String  tblWeather_main="main" ;
    public  static final  String  tblWeather_description = "desccription"  ;
    public  static final  String  tblWeather_icon ="icon" ;



    public  static final  String tblCoord= "coord";
    public  static final  String tblCoord_id= "id";
    public  static final  String tblCoord_lat= "lat";
    public  static final  String tblCoord_lon= "lon";


    private static final String TABLE_CREATE="CREATE TABLE "+tblCoord+"("+
            tblCoord_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            tblCoord_lat+" REAL,"+
            tblCoord_lon+" REAL);";

    private static final String TABLE_CREATE_MAIN="CREATE TABLE "+tblMain+"("+
            tblMain_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            tblMain_temp+" REAL,"+
            tblMain_feels_like+" REAL,"+
            tblMain_temp_min+" REAL,"+
            tblMain_temp_max+" REAL,"+
            tblMain_pressure+" INTEGER,"+
            tblMain_humidity+" INTEGER,"+
            tblMain_sea_level+" INTEGER,"+
            tblMain_grnd_level+" INTEGER);";

    private static final String TABLE_CREATE_WEATHER="CREATE TABLE "+tblWeather+"("+
            tblWeather_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                tblWeather_main+" TEXT,"+
                tblWeather_description+" TEXT,"+
                tblWeather_icon+" TEXT);"
            ;



    public SQLiteOpenHelper(Context context) {
        super(context, DataBaseName, null, DataBaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tblCoord);
        db.execSQL("DROP TABLE IF EXISTS "+tblMain);
        db.execSQL("DROP TABLE IF EXISTS "+tblWeather);
        onCreate(db);

    }








}
