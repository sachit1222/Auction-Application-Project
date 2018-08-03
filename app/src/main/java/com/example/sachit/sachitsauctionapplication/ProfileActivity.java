package com.example.sachit.sachitsauctionapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private String email;
   // private int balance =  10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);






 //       EditText etAddBalance = (EditText) findViewById(R.id.etAddBalance);
 //       Button btnAddBalance = (Button) findViewById(R.id.btnAddBalance);
        TextView etShowEmail = (TextView) findViewById(R.id.etShowEmail);
  //      TextView etShowBalance = (TextView) findViewById(R.id.etShowBalance);
//        etShowBalance.setText(balance);
        email = getIntent().getStringExtra("email");
        etShowEmail.setText(email);

//        btnAddBalance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//

    }

//    public void storeBalance(){
//
//    }
}
