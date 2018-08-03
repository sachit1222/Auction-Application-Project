package com.example.sachit.sachitsauctionapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SearchActivity extends AppCompatActivity {


   // private static final int TAG = 12;
    //  String item;
    ArrayList<String> items;
    ListView listView;
    EditText editText;
    EditText newEditText;
    private ArrayList<String> filterData;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        items = DataManagerBuyer.getInstance().getItems();

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.type_search);
       // newEditText = (EditText)findViewById(R.id.type_search);

    //    item = getIntent().getStringExtra("name");
    //    items.add(item);
       // adapter.notifyDataSetChanged(); ;)

        filterData = new ArrayList<>();
        filterData.addAll(items);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filterData);
        listView.setAdapter(adapter);

     //   Toast.makeText(getBaseContext(), items.get(9), Toast.LENGTH_SHORT).show();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i).toString();
                Intent intent = new Intent(SearchActivity.this, BuyerActivity.class);
                Toast.makeText(SearchActivity.this, "" + text, Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putInt("item_index", i);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });


        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                search(s.toString());


            }
        });
    }

    private void search(String s) {

        if(s.trim().length() == 0){
            filterData.clear();
            filterData.addAll(items);
            adapter.notifyDataSetChanged();
        }
        else{
            filterData.clear();
            for(String value: items){
                if(value.toLowerCase().contains(s.trim().toLowerCase())){
                    filterData.add(value);
                }

            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        filterData.clear();
        filterData.addAll(items);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filterData);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_home) {
            Intent homeIntent = new Intent(SearchActivity.this, ApplicationInterface.class);
            SearchActivity.this.startActivity(homeIntent);
            return true;

        }
        return false;
    }
}




