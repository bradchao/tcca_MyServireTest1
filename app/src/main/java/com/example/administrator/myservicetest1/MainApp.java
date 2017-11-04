package com.example.administrator.myservicetest1;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2017/11/4.
 */

public class MainApp extends Application {
    static int nn;
    int aa;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("brad", "ApponCreate()");
    }
}
