package com.example.vinit.tripbudget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.password;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;
    private EditText num;
    private EditText pass;
    private String number;
    private TextView tv;
    String data;
    FirebaseDatabase db;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText)findViewById(R.id.Lnumber);

        tv = (TextView)findViewById(R.id.data);
        pass = (EditText)findViewById(R.id.Lpass);
        login = (Button)findViewById(R.id.Signin);


        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number = num.getText().toString();
                db = FirebaseDatabase.getInstance();
                ref = db.getReference().child("Users/"+number);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        data = dataSnapshot.getValue().toString();
                        User ud = dataSnapshot.getValue(User.class) ;
                        tv.setText(ud.getPassword());
//                        if(data.equals(pass.getText().toString())){
//                            //Go to next activity intent add data
//                            tv.setText("ok");
//                        }
//                        else{
//                            tv.setText("The password entered does not match with the number \n\n please try again");
//                        }

                        }
                     @Override
                    public void onCancelled(DatabaseError databaseError) {
                        num.setText("");
                         pass.setText("");
                         tv.setText("There was some error in data retreival pls try again in some time");
                    }
                });

            }
        });
        register = (Button)findViewById(R.id.Reg);
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class destination = register.class;
                Intent in  = new Intent(context,destination);
                startActivity(in);
            }
        });
    }
}
