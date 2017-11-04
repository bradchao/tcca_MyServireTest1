package com.example.administrator.myservicetest1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num;
    private MainApp mainApp;
    private TextView tv;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

        mainApp = (MainApp)getApplication();
        mainApp.aa = 123;

        num = (EditText)findViewById(R.id.num);

        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("brad");
        registerReceiver(myReceiver, filter);


    }


    @Override
    public void finish() {
        unregisterReceiver(myReceiver);
        super.finish();
    }

    public void test1(View view){
        try {
            int n = Integer.parseInt(num.getText().toString());
            MainApp.nn = n;
            Intent it = new Intent(this, MyService.class);
            it.putExtra("n", n);
            startService(it);
        }catch(NumberFormatException ne){

        }
    }

    public void test2(View view){
        Intent it = new Intent(this, MyService.class);
        stopService(it);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //int rand = intent.getIntExtra("rand", -1);
            int rand = intent.getIntExtra("caln", -1);
            tv.setText("" + rand);
        }
    }


}
