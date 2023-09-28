package com.example.vitpyqs;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ApplicationClass extends Application {
    public static final String APPLICATION_ID = "49A7B0B4-6714-6F7D-FF06-028B09626400";
    public static final String API_KEY = "62475662-77C6-4FAC-9535-09A150A859BA";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;

    public void onCreate(){
        super.onCreate();

        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}