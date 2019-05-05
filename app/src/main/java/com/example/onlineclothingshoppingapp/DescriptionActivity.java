package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {
private CircleImageView imgView;
private TextView tvItemName,tvItemPrice,tvItemDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgView = findViewById(R.id.itemImage);
        tvItemName = findViewById(R.id.tvItemName);
        tvItemPrice = findViewById(R.id.tvItemPrice);
        tvItemDescription = findViewById(R.id.tvItemDescription);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            imgView.setImageResource(bundle.getInt("image"));
            tvItemName.setText("Item Name :"+ bundle.getString("name"));
            tvItemPrice.setText("Item Price :"+ bundle.getString("price"));
            tvItemDescription.setText("Item Description :"+ bundle.getString("description"));


        }
    }
}
