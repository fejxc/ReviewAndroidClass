package com.example.sunyun.netanddate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    //        1.新建OKhttp  一个项目最好一个Okhttp对象  get post 都要用
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }
    public void get(View view){

//        2.新建一个request
//        .get()可以省略不写，推荐写
        Request request = new Request.Builder()
                                    .url("https://www.baidu.com/?tn=request_27_pg")
                                    .get()
                                    .build();
//        3.新建call请求  通过request 加入对列  有两个回调方法 失败 成功
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("MainActivity", "onGetFailure: 请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("MainActivity", "onGetOK: 请求成功");
            }
        });

    }

    public void post(View view){
        //        新建请求体
        RequestBody body = new FormBody.Builder()
                .add("input","zs2016")
                .add("password","123456")
                .build();
//        2.新建一个request
        final Request request = new Request.Builder()
                .url("http://192.168.13.109:8080/MobileShop/admin_manager/login")
                .post(body)
                .build();
//    3.新建一个Call请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("MainActivity", "onPostFailure: 请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("MainActivity", "onPostOk: 请求成功");
                final String str = response.body().string();
                Log.i("MainActivity", "onRespose"+str);
                final TextView user_name = (TextView) findViewById(R.id.post_userName);
                final TextView user_moblie = (TextView) findViewById(R.id.post_mobile);


//              ui更新，在主线程中显示
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        if(jsonObject.getInt("status") == 0 && jsonObject.getString("data") != null){
                            JSONObject jData = jsonObject.getJSONObject("data");
                            String real_name = jData.getString("real_name");
                            String mobile = jData.getString("mobile");
                            user_name.setText(real_name);
                            user_moblie.setText(mobile);

                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }


                    }
                });
            }
        });
    }

}
