package com.example.ironman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    TextView NameText;
    TextView EmailText;
    TextView AgeText;
    FirebaseDatabase database;
    DatabaseReference reference;
    private static final String USERS = "usersinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
Intent intent = getIntent();
String email = intent.getStringExtra("email");
        NameText = (TextView) findViewById(R.id.nametext);
        EmailText = (TextView) findViewById(R.id.emailtext);
        AgeText = (TextView) findViewById(R.id.agetext);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference(USERS);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        NameText.setText(dataSnapshot.child("name").getValue(String.class));
                        EmailText.setText(dataSnapshot.child("email").getValue(String.class));
                        AgeText.setText(dataSnapshot.child("age").getValue(String.class));

                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}