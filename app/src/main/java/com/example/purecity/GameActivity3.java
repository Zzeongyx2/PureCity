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
import android.widget.TextView;


public class GameActivity3 extends Activity  {
    private CountDownTimer percentCountDownTimer;
    private CountDownTimer randomCountDownTimer;

    private long randomTime;

    private ProgressBar progressBar;
    private int percentage = 0;
    private int level = 1;

    Handler handler = new Handler();

    private Button B1, B2, B3, B4, B5, B6;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        B1 = (Button) findViewById(R.id.B1);
        B2 = (Button) findViewById(R.id.B2);
        B3 = (Button) findViewById(R.id.B3);
        B4 = (Button) findViewById(R.id.B4);
        B5 = (Button) findViewById(R.id.B5);
        B6 = (Button) findViewById(R.id.B6);

        textView = (TextView) findViewById(R.id.bigtext);

        progressBar = findViewById(R.id.progressBar);

        if (level == 1) {
            percentage = 10;

        } else if (level == 2) {
            percentage = 25;

        } else {
            percentage = 50;
        }

        percentCountDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                //Log.d("GameActivity", "----- onTick -----");
                percentage+=3;
                progressBar.setProgress(percentage);
                if(percentage == 24){
                    int random_big = (int) (Math.random()*4);
                    switch(random_big){
                        case 0:
                            textView.setText("대규모 집회 발생!! 감염률이 30% 증가합니다.");
                            percentage = percentage + 30;
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run(){
                                    textView.setVisibility(View.INVISIBLE);
                                }
                            }, 6000);
                            break;
                        case 1:
                            textView.setText("해외 대량 입국!! 감염률이 10% 증가합니다.");
                            percentage = percentage + 10;
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run(){
                                    textView.setVisibility(View.INVISIBLE);
                                }
                            }, 6000);
                            break;
                        case 2:
                            textView.setText("명절 대규모 이동!! 감염률이 20% 증가합니다.");
                            percentage = percentage + 20;
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run(){
                                    textView.setVisibility(View.INVISIBLE);
                                }
                            }, 6000);
                            break;
                        case 3:
                            textView.setText("휴가철 대규모 이동!! 감염률이 15% 증가합니다.");
                            Log.d("======================", String.valueOf(random_big));
                            percentage = percentage + 15;
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run(){
                                    textView.setVisibility(View.INVISIBLE);
                                }
                            }, 6000);
                            break;
                        default:
                            break;
                    }
                }
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
                checkGameState(percentage);

            }



            @Override
            public void onFinish() {
                //Log.d("GameActivity", "----- onFinish Random -----");
//                randomTime = (long) (Math.random() * 10000);
                randomTime = 1000;
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
                percentage-=5;
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B2.setVisibility(View.INVISIBLE);
                percentage-=5;
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B3.setVisibility(View.INVISIBLE);
                percentage-=5;
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B4.setVisibility(View.INVISIBLE);
                percentage-=5;
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B5.setVisibility(View.INVISIBLE);
                percentage-=5;
            }
        });
        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B6.setVisibility(View.INVISIBLE);
                percentage-=5;
            }
        });
    }


    private void checkGameState(int percentage){
        if(percentage >= 100){
            Intent intent = new Intent(GameActivity3.this, GameOverActivity.class);
            startActivity(intent);
            finish();
        }
        if(percentage <= 0){
            Intent intent = new Intent(GameActivity3.this, Stage3Activity.class);
            startActivity(intent);
            finish();
        }
    }

    private void personNumber(int num, String message){
        switch(num){
            case 0:
                B1.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B1.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B1.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B1.setBackgroundResource(R.drawable.temp);
                }else{
                    B1.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B1.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            case 1:
                B2.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B2.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B2.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B2.setBackgroundResource(R.drawable.temp);
                }else{
                    B2.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B2.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            case 2:
                B3.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B3.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B3.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B3.setBackgroundResource(R.drawable.temp);
                }else{
                    B3.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B3.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            case 3:
                B4.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B4.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B4.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B4.setBackgroundResource(R.drawable.temp);
                }else{
                    B4.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B4.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            case 4:
                B5.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B5.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B5.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B5.setBackgroundResource(R.drawable.temp);
                }else{
                    B5.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B5.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            case 5:
                B6.setVisibility(View.VISIBLE);
                if(message == "마스크"){
                    B6.setBackgroundResource(R.drawable.mask);
                }else if(message == "손소독"){
                    B6.setBackgroundResource(R.drawable.sanitizer);
                }else if(message == "체온"){
                    B6.setBackgroundResource(R.drawable.temp);
                }else{
                    B6.setBackgroundResource(R.drawable.people);
                }
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        B6.setVisibility(View.INVISIBLE);
                    }
                }, 5000);
            default:
                break;
        }
    }

    private String eventCall(int random) {
        final int eventRun = (int) (Math.random() * 100)+1;
        Log.d("=================random", String.valueOf(eventRun));
        if (random == 0) {
            if (eventRun < 100) {
                B1.setSelected(true);
//                B1.setBackgroundResource(R.drawable.mask);
                return "마스크";
            } else {
                return null;
            }

        } else if (random == 1) {
            if (eventRun < 100) {
//                B1.setBackgroundResource(R.drawable.sanitizer);
                return "손소독";
            } else {
                return null;
            }

        } else if (random == 2) {
            if (eventRun < 100) {
//                B1.setBackgroundResource(R.drawable.temp);
                return "체온";
            } else {
                return null;
            }

        } else if (random == 3) {
            if (eventRun < 100) {
//                B1.setBackgroundResource(R.drawable.people);
                return "모임 해산";
            } else {
                return null;
            }

        } else {
            return null;
        }

    }

}