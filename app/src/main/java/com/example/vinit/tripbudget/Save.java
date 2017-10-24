package com.example.vinit.tripbudget;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONObject;

import java.util.Collections;

/**
 * Created by Vinit on 20-10-2017.
 */

public class Save {


    public String adder(User u){
        try{

            JSONObject obj = new JSONObject();
            obj.put("Name",u.getName());
            obj.put("Number",u.getNumber());
            obj.put("Password",u.getPassword());
            obj.put("Total_Amt",u.getTotalAmount());
            //Log.d("this",u.getTrp().toString());
            //obj.put("my_trip", u.getTrp());
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference ref = db.getReference("Users");
            ref.child(u.getNumber()).setValue(u);
            return obj.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
