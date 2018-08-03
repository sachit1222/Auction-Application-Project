package com.example.sachit.sachitsauctionapplication;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BuyerActivity extends AppCompatActivity {

    private TextView name, startingPrice, buyoutPrice, description;
    private String getName, getDescription, getStartingPrice, getBuyoutPrice;
    private Button btnDone, btnBuyNow, btnBid;
    private int itemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);

        getName = getIntent().getStringExtra("name");
        itemIndex = getIntent().getIntExtra("item_index", -1);

        final TextView name = (TextView)findViewById(R.id.tvShowProductName);
        final TextView description = (TextView)findViewById(R.id.tvShowProductDescription);
        final TextView startingPrice = (TextView)findViewById(R.id.tvShowProductStartingBid);
        final TextView buyoutPrice = (TextView)findViewById(R.id.tvShowProductBuyoutPrice);
        Button btnDone = (Button)findViewById(R.id.btnHomeScreen);
        Button btnBid = (Button)findViewById(R.id.btnBid);
        Button btnBuyNow = (Button)findViewById(R.id.btnBuyNow);

        //Done
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataManagerBuyer.getInstance().addItems(getName);
                Toast.makeText(BuyerActivity.this, "Your item has been posted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BuyerActivity.this, SearchActivity.class);

               // intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        //Buy Now
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(BuyerActivity.this);
                builder.setTitle("Buy Now");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("BUY NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(itemIndex == -1) {
                            Toast.makeText(BuyerActivity.this, "No item has been selected", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(BuyerActivity.this, "Thanks for your purchase", Toast.LENGTH_SHORT).show();
                            DataManagerBuyer.getInstance().removeItem(itemIndex);
                        }

                        finish();

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.show();
            }
        });

        btnBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BuyerActivity.this);
                builder.setTitle("Bid Now");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("BID NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //  String name1 = name.getText().toString();
                        //   Bundle bundle =  new Bundle();
                        //   bundle.putString("name", name1);

                          Toast.makeText(BuyerActivity.this, "Thanks your bid", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(BuyerActivity.this, SearchActivity.class);
//                        startActivity(intent);

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.show();

            }
        });




        name.setText(getName);
        getBuyoutPrice = getIntent().getStringExtra("buyout price");
        buyoutPrice.setText(getBuyoutPrice);
        getStartingPrice = getIntent().getStringExtra("starting price");
        startingPrice.setText(getStartingPrice);
        getDescription = getIntent().getStringExtra("description");
        description.setText(getDescription);









    }

}
