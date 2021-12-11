package com.example.ec2isaac.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.ec2isaac.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LocationEntry {
    private static final String TAG = LocationEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String country;

    public LocationEntry(String title, String dynamicUrl, String url, String country){
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.country = country;
    }

    public static List<LocationEntry> initLocationEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.locations);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;

            while ((pointer = reader.read(buffer)) != -1){
                writer.write(buffer,0,pointer);
            }
        }catch (IOException exception){
            Log.e(TAG,"Hubo un error al momento de leer y escribir el archivo");
        }finally {
            try {
                inputStream.close();
            }catch (IOException exception){
                Log.e(TAG,"Hubo un error al momento de cerrar el input stream", exception);
            }
        }

        String jsonLocationsString = writer.toString();

        Gson gson = new Gson();
        Type locationsListType = new TypeToken<ArrayList<LocationEntry>>(){

        }.getType();

        return gson.fromJson(jsonLocationsString, locationsListType);
    }
}
