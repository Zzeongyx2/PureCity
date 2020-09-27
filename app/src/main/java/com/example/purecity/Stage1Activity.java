package com.example.purecity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Stage1Activity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage1);
        final Button B1;

        B1 = (Button) findViewById(R.id.NextStage);
        B1.setVisibility(View.VISIBLE);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("1", "눌림");

                Intent intent = new Intent(Stage1Activity.this, GameActivity2.class);
                startActivity(intent);
                finish();

            }
        }); }
}