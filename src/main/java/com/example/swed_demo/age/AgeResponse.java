package com.example.swed_demo.age;


public class AgeResponse {

    private int age;
    private String bracket;


    public AgeResponse(int age, String bracket) {
        this.age = age;
        this.bracket = bracket;
    }


    public int getAge() {
        return age;
    }


    public String getBracket() {
        return bracket;
    }
}