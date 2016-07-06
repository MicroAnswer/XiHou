package com.share.xihou;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class logoActivity extends Activity {
    Chronometer ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        ch= (Chronometer) findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime()-ch.getBase()>2*1000){
                    ch.stop();
                    Intent intent = new Intent();
                    intent.setClass(logoActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}
