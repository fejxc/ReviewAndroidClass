package com.example.sunyun.gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.sunyun.gson.entity.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by sunyun on 2021/4/9.
 */

public class MapJsonActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Map比List多了一个String类型的key，map的value是list集合
        String mapJson="{\n" +
                "\"1\":{\"name\":\"sunyun\",\"age\":\"22\",\"id\":\"1809102021\"},\n" +
                "\"2\":{\"name\":\"lisi\",\"age\":\"24\",\"id\":\"1809102022\"},\n" +
                "\"3\":{\"name\":\"zhangsan\",\"age\":\"12\",\"id\":\"1809102023\"}\n" +
                "}";

        Gson gson = new Gson();
        Map<String,Student> studentMap;

        studentMap = gson.fromJson(mapJson, new TypeToken<Map<String,Student>>(){}.getType());

        Log.e("StudentLog","sunyun的学号："+studentMap.get("1").getId());
        Log.e("StudentLog","lisi的学号："+studentMap.get("2").getId());
        Log.e("StudentLog","zhangsan的学号："+studentMap.get("3").getId());

    }
}
