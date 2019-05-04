package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {
    private EditText etItemName,etItemPrice,etItemImageName,etItemDescription;
    private Button btnAddItem;
    //additem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName=findViewById(R.id.etItemName);
        etItemPrice=findViewById(R.id.etItemPrice);
        etItemImageName=findViewById(R.id.etItemImageName);
        etItemDescription=findViewById(R.id.etItemDescription);
        btnAddItem=findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
            private void Save() {
                    try {
                        PrintStream printStream = new PrintStream(openFileOutput("Items.txt", MODE_PRIVATE | MODE_APPEND));
                        printStream.println(etItemName.getText().toString());
                        printStream.println(etItemPrice.getText().toString());
                        printStream.println(etItemImageName.getText().toString());
                        printStream.println(etItemDescription.getText().toString());
                        Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        Log.d("OnlineClothingShoppingApp","Error"+e.toString());
                        e.printStackTrace();
                    }
                }
            }

