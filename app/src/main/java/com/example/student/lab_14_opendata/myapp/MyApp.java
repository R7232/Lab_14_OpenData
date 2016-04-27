package com.example.student.lab_14_opendata.myapp;

import android.app.Application;
import android.content.Context;

import com.example.student.lab_14_opendata.benas.TaipeAttractionsBean;


public class MyApp extends Application{

    private static Context context ;
    private static TaipeAttractionsBean taipeAttractionsBean ;



    // get
    public static Context getContext() {
        return context;
    }

    public static TaipeAttractionsBean getTaipeAttractionsBean() {
        return taipeAttractionsBean;
    }

    // set
    public static void setTaipeAttractionsBean(TaipeAttractionsBean taipeAttractionsBean) {
        MyApp.taipeAttractionsBean = taipeAttractionsBean;
    }

    public MyApp() {
        context = this; // context 就是 MyApp 自己
    }
}
