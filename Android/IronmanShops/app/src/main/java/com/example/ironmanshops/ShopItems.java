package com.example.ironmanshops;

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

public class ShopItems extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    RecyclerView recview;
    myadapter myadapter;
    Button button;

    FirebaseDatabase database;
    DatabaseReference reference;
    private static final String USERS = "Users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_items);

        textView=(TextView)findViewById(R.id.t11);
        textView1=(TextView)findViewById(R.id.t12);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference(USERS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                textView.setText(dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("shopName").getValue(String.class));
                textView1.setText(dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("address").getValue(String.class));


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        recview=(RecyclerView)findViewById(R.id.recviewforitem);
        recview.setLayoutManager(new LinearLayoutManager(this));




        FirebaseRecyclerOptions<itemhelper> options =
                new FirebaseRecyclerOptions.Builder<itemhelper>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .child("items"), itemhelper.class)
                        .build();

        myadapter=new myadapter(options,getApplicationContext());
        recview.setAdapter(myadapter);



        button = (Button) findViewById(R.id.additem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopItems.this,additem.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
       myadapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        myadapter.stopListening();

    }
}