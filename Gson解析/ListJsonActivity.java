package com.example.sunyun.gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.sunyun.gson.entity.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyun on 2021/4/9.
 */

public class ListJsonActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String list_json = "[{\n" +
                "  \"id\": 1,\n" +
                "  \"first_name\": \"Jeanette\",\n" +
                "  \"last_name\": \"Penddreth\",\n" +
                "  \"email\": \"jpenddreth0@census.gov\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"ip_address\": \"26.58.193.2\"\n" +
                "}, {\n" +
                "  \"id\": 2,\n" +
                "  \"first_name\": \"Giavani\",\n" +
                "  \"last_name\": \"Frediani\",\n" +
                "  \"email\": \"gfrediani1@senate.gov\",\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"ip_address\": \"229.179.4.212\"\n" +
                "}, {\n" +
                "  \"id\": 3,\n" +
                "  \"first_name\": \"Noell\",\n" +
                "  \"last_name\": \"Bea\",\n" +
                "  \"email\": \"nbea2@imageshack.us\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"ip_address\": \"180.66.162.255\"\n" +
                "}, {\n" +
                "  \"id\": 4,\n" +
                "  \"first_name\": \"win7_two\",\n" +
                "  \"last_name\": \"Valek\",\n" +
                "  \"email\": \"wvalek3@vk.com\",\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"ip_address\": \"192.168.200.4\"\n" +
                "}\n" +
                "]";
        Gson gson = new Gson();

        List<Person> persons;
        Type type = new TypeToken<ArrayList<Person>>(){}.getType();
        persons = gson.fromJson(list_json,type);

        for(Person person:persons){
            Log.e("MainActivity","id:"+person.getId()+" fist_name:"+person.getFirst_name()+" ip_addr:"+
            person.getIp_address());
        }
    }
}
