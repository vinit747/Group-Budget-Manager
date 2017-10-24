package com.example.vinit.tripbudget;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Vinit on 18-10-2017.
 */

public class User {
    private String name;
    private String number;
    private String password;
    private float totalAmount;
    //private List<Trips>Mytrips;
    //private List<Map<String,Float>>Tr;

    void setAll(String n,String num,String pass,float AmT){
        name = n;
        number = num;
        password = pass;
        totalAmount = AmT;
    }
    String getNumber(){
        return number;
    }
    String getPassword(){
        return password;
    }
    float getTotalAmount(){
        return totalAmount;
    }
    String getName(){
        return name;
    }
//    List getTrp(){
//        return Mytrips;
//    }
//    public class Trips{
//        private String name;
//        private float tripAmount;
//        void setTrips(String n,float tpa){
//            name = n;
//            tripAmount = tpa;
//        }
//        String getName(){
//            return name;
//        }
//        float getTripAmount(){
//            return tripAmount;
//        }
//    }
}
