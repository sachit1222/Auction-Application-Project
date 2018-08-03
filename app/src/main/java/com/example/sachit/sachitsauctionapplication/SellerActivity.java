package com.example.sachit.sachitsauctionapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SellerActivity extends AppCompatActivity {

    private EditText name, startingPrice, buyoutPrice, description;
    private Button post;
    private Item item;
    private DatabaseReference databaseItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);


        EditText name = (EditText)findViewById(R.id.etNameProduct);
        EditText description = (EditText)findViewById(R.id.etDescriptionProduct);
        EditText startingPrice = (EditText)findViewById(R.id.etStartingPrice);
        EditText buyoutPrice = (EditText)findViewById(R.id.etBuyoutPrice);
        Button post = (Button)findViewById(R.id.btnPost);



        databaseItems   = FirebaseDatabase.getInstance()
               .getReferenceFromUrl("https://sachit-aa.firebaseio.com/items");



        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addItems();
                EditText name = (EditText) findViewById(R.id.etNameProduct);
                EditText description = (EditText)findViewById(R.id.etDescriptionProduct);
                EditText startingPrice = (EditText)findViewById(R.id.etStartingPrice);
                EditText buyoutPrice = (EditText)findViewById(R.id.etBuyoutPrice);

                String name2 = name.getText().toString();
                String desc = description.getText().toString();
                String sp = startingPrice.getText().toString();
                String buyout = buyoutPrice.getText().toString();



                Bundle bundle =  new Bundle();
                bundle.putString("name", name2);
                Bundle bundle2 =  new Bundle();
                bundle.putString("description", desc);
                Bundle bundle3 =  new Bundle();
                bundle.putString("starting price", sp);
                Bundle bundle4 =  new Bundle();
                bundle.putString("buyout price", buyout);

                Intent intent = new Intent(SellerActivity.this, BuyerActivity.class);
                intent.putExtras(bundle);
                intent.putExtras(bundle2);
                intent.putExtras(bundle3);
                intent.putExtras(bundle4);
                startActivity(intent);

            }
        });
    }
    private void addItems(){
        EditText name = (EditText)findViewById(R.id.etNameProduct);
        EditText description = (EditText)findViewById(R.id.etDescriptionProduct);
        EditText startingPrice = (EditText)findViewById(R.id.etStartingPrice);
        EditText buyoutPrice = (EditText)findViewById(R.id.etBuyoutPrice);

        String name1 = name.getText().toString().trim();
        String description1 = description.getText().toString().trim();
        String startingPrice1 = startingPrice.getText().toString().trim();
        String buyoutPrice1 = buyoutPrice.getText().toString().trim();

        if(!TextUtils.isEmpty(name1)){
            String id = databaseItems.push().getKey();

            Item item = new Item(name1, description1, startingPrice1, buyoutPrice1);

            databaseItems.child(id).setValue(item);

            Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_SHORT).show();
        }
    }
}
