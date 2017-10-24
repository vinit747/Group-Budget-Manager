package com.example.vinit.tripbudget;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener {

    private Button cancel;
    private Button reg;
    private EditText name;
    private EditText num;
    private EditText passw;
    private EditText cpassw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.nameIp);
        num = (EditText)findViewById(R.id.numberIp);
        passw = (EditText)findViewById(R.id.pass);
        cpassw = (EditText)findViewById(R.id.cpass);
        cancel = (Button)findViewById(R.id.cancel_reg);
        cancel.setOnClickListener(this);
        reg = (Button)findViewById(R.id.confirm_reg);
        reg.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.cancel_reg:
                AlertDialog ad = new AlertDialog.Builder(this)
                        .setMessage("The Data you entered Will not be Saved \n Do You Wish To Continue\n")
                        .setTitle("Cancel")
                        .setPositiveButton("Yes",this)
                        .setNegativeButton("NO",this)
                        .setCancelable(false)
                        .create();
                ad.show();
                break;
            case R.id.confirm_reg:
                if(cpassw.getText().toString().equals(passw.getText().toString())){
                    User u =new User();
                    u.setAll(name.getText().toString(),num.getText().toString(),passw.getText().toString(), 0.0f);
//                    User.Trips tr = u.new Trips();
                    //tr.setTrips();
                    Save ss = new Save();
                    ss.adder(u);
                    name.setText("");
                    num.setText("");
                    passw.setText("");
                    cpassw.setText("");
                    Toast.makeText(this, "User Regeristration Successfull!",Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    AlertDialog ad1 = new AlertDialog.Builder(this)
                            .setMessage("The passwords do not match\n User cannot be registered")
                            .setTitle("Incorrect Passwords")
                            .setCancelable(false)
                            .setNeutralButton("Ok",this)
                            .create();
                    ad1.show();
                    passw.setText("");
                    cpassw.setText("");
                }
                break;
        }

    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                name.setText("");
                num.setText("");
                passw.setText("");
                cpassw.setText("");
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                break;

        }
    }
}
