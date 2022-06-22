package com.example.ironmanshops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class additem extends AppCompatActivity {
    EditText itemname;
    EditText itemprice;
    Button button;

    FirebaseAuth mAuth;
    FirebaseStorage storage;
    StorageReference storageReference;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        itemname =(EditText) findViewById(R.id.addname);
        itemprice =(EditText) findViewById(R.id.addprice);
        mAuth=FirebaseAuth.getInstance();

        button = (Button) findViewById(R.id.added);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = itemname.getText().toString().trim();
                String price = itemprice.getText().toString().trim();

                itemhelper itemhelper= new itemhelper(name,price);



                FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child("items")
                        .push()
                        .setValue(itemhelper).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(additem.this, "Added successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(additem.this,ShopItems.class);
                            startActivity(intent);
                        }
                    }
                });


            }
        });
    }
}