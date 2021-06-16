package com.example.sunyun.gson.entity;

/**
 * Created by sunyun on 2021/4/9.
 */

public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
    public String getIp_address() {
        return ip_address;
    }

}
