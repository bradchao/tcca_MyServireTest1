package com.example.administrator.myservicetest1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private int n = 10;

    public MyService() {
        Log.i("brad", "MyService()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("brad", "onBind()");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("brad", "onCreate()");
        timer = new Timer();
        //timer.schedule(new MyTask(), 0, 1000);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        n = intent.getIntExtra("n", n);
        Log.i("brad", "onStartCommand");

        Intent it = new Intent("brad");
        it.putExtra("caln", calfx(n));
        sendBroadcast(it);
        return super.onStartCommand(intent, flags, startId);
    }

    private int calfx(int x){
        return 2*x + 1;
    }


    private class MyTask extends TimerTask {
        @Override
        public void run() {
            int rand = (int)(Math.random()*n);
            Log.i("brad", "rand = " + rand);

            Intent it = new Intent("brad");
            it.putExtra("rand", rand);
            sendBroadcast(it);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("brad", "onDestroy()");

        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }

    }
}
