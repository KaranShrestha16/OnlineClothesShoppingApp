package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ItemsAdapter;
import model.ItemsProperties;

public class DashboardActivity extends AppCompatActivity {
    private Button btnAddItem;
    private RecyclerView recyclerView;
    List<ItemsProperties> itemsList = new ArrayList<ItemsProperties>();
//dashboard
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddItem=findViewById(R.id.btnAddItem);
        recyclerView = findViewById(R.id.recyclerView);

        readFromFile();
        ItemsAdapter itemAdapter = new ItemsAdapter(this,itemsList);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(DashboardActivity.this, AddItemActivity.class);
                startActivity(I);

            }
        });
    }


    private void readFromFile(){

        try {
            FileInputStream fileInputStream = openFileInput("items.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line= "";

            while((line = bufferedReader.readLine()) !=null) {
                String[] parts = line.split("->");
                String imgDrawable =parts[1];
                int id=getResources().getIdentifier(imgDrawable,"drawable",getPackageName());
                itemsList.add(new ItemsProperties(parts[0],id,parts[2],parts[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
