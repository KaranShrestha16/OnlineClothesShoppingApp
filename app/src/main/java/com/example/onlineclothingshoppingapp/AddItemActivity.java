package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;



public class AddItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText etItemName, etItemPrice, etItemDescription;
    private String imageName;
    private Button btnAddItem;
    //additem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etItemDescription = findViewById(R.id.etItemDescription);
        btnAddItem = findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
        Spinner spinner = findViewById(R.id.spinnerImage);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.imageList, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageName = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), imageName, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


            private void Save() {
                try {

                    PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE | MODE_APPEND));
                    printStream.println(etItemName.getText().toString() + "->" + imageName + "->" + etItemPrice.getText().toString() + "->" + etItemDescription.getText().toString());
                    Toast.makeText(this, "successfully added", Toast.LENGTH_SHORT).show();
                    etItemDescription.setText("");
                    etItemPrice.setText("");
                    etItemName.setText("");
                    Intent intent = new Intent(AddItemActivity.this, DashboardActivity.class);
                    startActivity(intent);

            } catch (FileNotFoundException e) {
                    Log.d("this", "Error" + e.toString());
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }


    }



