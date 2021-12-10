package com.example.ec2isaac.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class EC2Application extends Application {
    private static EC2Application instance;
    private static Context appContext;

    public static EC2Application getInstance(){
        return instance;
    }

    public static Context getAppContext(){
        return appContext;
    }

    public void setAppContext(Context mAppContext){
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
