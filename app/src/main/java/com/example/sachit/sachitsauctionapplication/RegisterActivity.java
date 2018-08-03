package com.example.sachit.sachitsauctionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText etPassword, etEmail, etLocation, etName;
    private Button register;
    private DatabaseReference databaseUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseUsers   = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://sachit-aa.firebaseio.com/Users");

        firebaseAuth = FirebaseAuth.getInstance();
        setUIViews();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate()) {

                    String user_email = etEmail.getText().toString().trim();
                    String user_password = etPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword (user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                //adds a user object to the database
                                createUser();

                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, ApplicationInterface.class));
                            }
                            else{

                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });



    }


    protected void setUIViews(){


        etName = (EditText) findViewById(R.id.etName2);
        etPassword = (EditText) findViewById(R.id.etPassword2);
        etEmail = (EditText) findViewById(R.id.etEmail2);
        etLocation = (EditText) findViewById(R.id.etLocation2);

        register = (Button) findViewById(R.id.btnRegister);


    }

    private Boolean validate(){
        Boolean result = false;

        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String email = etEmail.getText().toString();
        String location = etLocation.getText().toString();

        if(password.isEmpty() || email.isEmpty() || name.isEmpty() || location.isEmpty()){

            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();

        }

        else{
            result = true;
        }

        return result;

    }


        private void createUser(){
            EditText name = (EditText)findViewById(R.id.etName2);
            EditText location = (EditText)findViewById(R.id.etLocation2);
            EditText email = (EditText)findViewById(R.id.etEmail2);
           // EditText buyoutPrice = (EditText)findViewById(R.id.etBuyoutPrice);

            String name1 = name.getText().toString().trim();
            String location1 = location.getText().toString().trim();
            String email1 = email.getText().toString().trim();
           // String buyoutPrice1 = buyoutPrice.getText().toString().trim();

            if(!TextUtils.isEmpty(name1)){
                String id = databaseUsers.push().getKey();


                User user = new User(email1, name1, location1, 10000, id);

                databaseUsers.child(id).setValue(user);

             //  Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(this, "You should enter a name", Toast.LENGTH_SHORT).show();
            }

    }
}
