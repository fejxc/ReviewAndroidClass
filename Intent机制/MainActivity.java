package com.example.sunyun.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        TextView textView = (TextView)findViewById(R.id.text_01);
        textView.setText("井冈山大学");

        Button button = (Button) findViewById(R.id.button_01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("通知");
                builder.setMessage("这是一段提示");
                //点击“确认”
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你选择确定",Toast.LENGTH_LONG).show();

                    }
                });

                //点击 取消
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你选择了取消",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }

        });


        Button button2 = (Button) findViewById(R.id.button_02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent机制
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);

            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("1","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("1","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("1","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("1","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("1","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("1","onRestart");
    }
}
