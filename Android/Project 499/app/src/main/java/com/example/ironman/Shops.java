package com.example.ironman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Shops extends AppCompatActivity {
    RecyclerView recview;
    RecyclerView recview1;
    myadapter adapter;
    myadapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        recview1=(RecyclerView)findViewById(R.id.recview2);
        recview1.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelshop> options =
                new FirebaseRecyclerOptions.Builder<modelshop>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("shops"), modelshop.class)
                        .build();

        adapter=new myadapter(options,getApplicationContext());
        recview.setAdapter(adapter);

        FirebaseRecyclerOptions<modelshop2> options2 =
                new FirebaseRecyclerOptions.Builder<modelshop2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users"), modelshop2.class)
                        .build();
        adapter2= new myadapter2(options2,getApplicationContext());
        recview1.setAdapter(adapter2);


    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        adapter2.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
        adapter2.stopListening();
    }


}