package com.example.rider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Orderdetails extends AppCompatActivity {
    TextView product1;
    TextView product2;
    TextView product3;
    TextView product1p;
    TextView product2p;
    TextView product3p;
    Button cobutton;
    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private static final String USERS = "usersinfo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);
        product1 = (TextView)findViewById(R.id.c1) ;
        product2 = (TextView)findViewById(R.id.c2) ;
        product3 = (TextView)findViewById(R.id.c3) ;
        product1p = (TextView)findViewById(R.id.c4) ;
        product2p = (TextView)findViewById(R.id.c5) ;
        product3p = (TextView)findViewById(R.id.c6) ;

        mAuth=FirebaseAuth.getInstance();
        cobutton=(Button)findViewById(R.id.co1);


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Orders").child("");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                product1.setText(dataSnapshot.child("item1").getValue(String.class));
                product1p.setText(dataSnapshot.child("item1price").getValue(String.class));
               product2.setText(dataSnapshot.child("item2").getValue(String.class));
                product2p.setText(dataSnapshot.child("item2price").getValue(String.class));

                product3.setText(dataSnapshot.child("item3").getValue(String.class));

                product3p.setText(dataSnapshot.child("item3price").getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        cobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Orderdetails.this,ImageClassify.class);
                startActivity(intent);
            }
        });

    }
}