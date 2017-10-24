package com.example.vinit.tripbudget;

import java.util.List;

/**
 * Created by Vinit on 20-10-2017.
 */

public class Trip {
    private String name;
    private float Tot_amt;

    void setAll(String n,float num){
        name = n;
        Tot_amt = num;
    }
    String getName(){
        return name;
    }
    float getTot(){
        return Tot_amt;
    }
}
