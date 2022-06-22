package com.example.ironman;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class UpdateProfile extends AppCompatActivity {
    EditText Name;
    EditText Email;
    EditText Age;
    ImageView Profile;
    public Uri imageUri;
    Button Button;
    FirebaseAuth mAuth;
    FirebaseStorage storage;
    StorageReference storageReference;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        Name=(EditText)findViewById(R.id.name);
        Email =(EditText)findViewById(R.id.email);
        Age=(EditText)findViewById(R.id.age);
        Button=(Button)findViewById(R.id.sign);
        mAuth=FirebaseAuth.getInstance();



        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String age = Age.getText().toString().trim();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("usersinfo");
                Userhelper2 helperclass2 = new Userhelper2(name,email,age);


                Intent intent = new Intent(UpdateProfile.this,dashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                reference.setValue(helperclass2);
            }
        });

    }


    }

