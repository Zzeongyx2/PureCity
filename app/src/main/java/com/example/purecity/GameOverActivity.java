package com.example.purecity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GameOverActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        final Button Button;

        Button = (Button) findViewById(R.id.NextStage);
//        Button.setVisibility(View.VISIBLE);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("1", "눌림");

                Intent intent = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(intent);
                finish();

            }
        }); }
}