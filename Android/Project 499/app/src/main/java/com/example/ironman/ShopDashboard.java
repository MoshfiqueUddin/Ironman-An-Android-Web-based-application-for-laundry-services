package com.example.ironman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShopDashboard extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    RecyclerView recview11;
    itemadapter iadapter;

    Button button;

    FirebaseDatabase database;
    DatabaseReference reference;
    private static final String USERS = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_dashboard);


        textView=(TextView)findViewById(R.id.t111);
        textView1=(TextView)findViewById(R.id.t122);

        textView.setText(getIntent().getStringExtra("name"));
        textView1.setText(getIntent().getStringExtra("address"));

       button =(Button) findViewById(R.id.addtocart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopDashboard.this,Addtocart.class);
                startActivity(intent);
            }
        });

        recview11=(RecyclerView)findViewById(R.id.recviewforitem1);
        recview11.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<itemhelper> options3 =
                new FirebaseRecyclerOptions.Builder<itemhelper>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("items"), itemhelper.class)
                        .build();

        iadapter =new itemadapter(options3,getApplicationContext());
        recview11.setAdapter(iadapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        iadapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        iadapter.stopListening();

    }


}