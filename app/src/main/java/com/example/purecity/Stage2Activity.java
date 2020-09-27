package com.example.purecity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Stage2Activity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);
        final Button B1;

        B1 = (Button) findViewById(R.id.NextStage);
        B1.setVisibility(View.VISIBLE);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("1", "눌림");

                Intent intent = new Intent(Stage2Activity.this, GameActivity3.class);
                startActivity(intent);
                finish();

            }
        }); }
}