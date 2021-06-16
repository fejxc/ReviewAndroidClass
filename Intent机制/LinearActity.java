package com.example.sunyun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by sunyun on 2021/5/21.
 */

public class LinearActity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        Button personBtn = findViewById(R.id.personl);
        personBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinearActity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
