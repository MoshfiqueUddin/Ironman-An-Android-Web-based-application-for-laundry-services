package com.example.ironman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Shop extends AppCompatActivity {
ImageView image;
TextView name;
TextView service;
TextView address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        image=(ImageView) findViewById(R.id.shop_img);
        name=(TextView)findViewById(R.id.shop_name);
        service=(TextView)findViewById(R.id.shop_service);
        address=(TextView)findViewById(R.id.shop_address);
        image.setImageResource(getIntent().getIntExtra("image",0));
        name.setText(getIntent().getStringExtra("name"));
        service.setText(getIntent().getStringExtra("service"));
        address.setText(getIntent().getStringExtra("address"));
    }
}