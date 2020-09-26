package com.example.purecity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class GameActivity extends Activity  {
    private CountDownTimer percentCountDownTimer;
    private CountDownTimer randomCountDownTimer;

    private long randomTime;

    private ProgressBar progressBar;
    private int percentage = 0;
    private int level = 1;

    private Button B1, B2, B3, B4, B5, B6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        B1 = (Button) findViewById(R.id.B1);
        B2 = (Button) findViewById(R.id.B2);
        B3 = (Button) findViewById(R.id.B3);
        B4 = (Button) findViewById(R.id.B4);
        B5 = (Button) findViewById(R.id.B5);
        B6 = (Button) findViewById(R.id.B6);

        progressBar = findViewById(R.id.progressBar);

        if (level == 1) {
            percentage = 10;

        } else if (level == 2) {
            percentage = 20;

        } else {
            percentage = 30;
        }

        percentCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                //Log.d("GameActivity", "----- onTick -----");
                percentage++;
                progressBar.setProgress(percentage);
            }

            @Override
            public void onFinish() {
                //Log.d("GameActivity", "----- onFinish -----");
                percentCountDownTimer.start();
            }
        };

        randomTime = (long) (Math.random() * 10000);

        randomCountDownTimer = new CountDownTimer(10000, randomTime) {
            @Override
            public void onTick(long l) {
                //Log.d("GameActivity", "----- onTick Random -----");

                int random = (int) (Math.random()*4);
                int random_person = (int) (Math.random()*6);

                if(eventCall(random) == "마스크") {
                    Log.d("Call",  "----- call1 -----");
                    personNumber(random_person, "마스크");

                } else if(eventCall(random) == "손소독") {
                    Log.d("Call",  "----- call2 -----");
                    personNumber(random_person, "손소독");

                } else if(eventCall(random) == "체온") {
                    Log.d("Call",  "----- call3 -----");
                    personNumber(random_person, "체온");

                } else if(eventCall(random) == "모임해산") {
                    Log.d("Call",  "----- call4 -----");
                    personNumber(random_person, "모임해산");

                }

            }

            @Override
            public void onFinish() {
                //Log.d("GameActivity", "----- onFinish Random -----");
                randomTime = (long) (Math.random() * 10000);
                //Log.d("GameActivity", "----- onFinish Random" + randomTime + " -----");
                randomCountDownTimer.start();
            }
        };

        progressBar.setProgress(percentage);
        percentCountDownTimer.start();
        randomCountDownTimer.start();

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B1.setVisibility(View.INVISIBLE);
            }
        });


    }

    private void personNumber(int num, String message){
        switch(num){
            case 0:
                B1.setVisibility(View.VISIBLE);
                B1.setText(message);
            case 1:
                B2.setVisibility(View.VISIBLE);
                B2.setText(message);
            case 2:
                B3.setVisibility(View.VISIBLE);
                B3.setText(message);
            case 3:
                B4.setVisibility(View.VISIBLE);
                B4.setText(message);
            case 4:
                B5.setVisibility(View.VISIBLE);
                B5.setText(message);
            case 5:
                B6.setVisibility(View.VISIBLE);
                B6.setText(message);
            default:
                break;
        }
    }

    private String eventCall(int random) {
        final int eventRun = (int) (Math.random() * 100)+1;
        Log.d("=================random", String.valueOf(eventRun));
        if (random == 0) {
            if (eventRun < 50) {
                return "마스크";
            } else {
                return null;
            }

        } else if (random == 1) {
            if (eventRun < 50) {
                return "손소독";
            } else {
                return null;
            }

        } else if (random == 2) {
            if (eventRun < 30) {
                return "체온";
            } else {
                return null;
            }

        } else if (random == 3) {
            if (eventRun < 10) {
                return "모임 해산";
            } else {
                return null;
            }

        } else {
            return null;
        }

    }

}