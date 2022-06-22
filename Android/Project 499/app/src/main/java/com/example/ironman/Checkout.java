package com.example.ironman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Checkout extends AppCompatActivity {
    TextView product1;
    TextView product2;
    TextView product3;
    TextView product1p;
    TextView product2p;
    TextView product3p;
    Button cobutton;
    FirebaseAuth mAuth;

    FirebaseDatabase rootNode1;
    DatabaseReference reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        product1 = (TextView)findViewById(R.id.c1) ;
        product2 = (TextView)findViewById(R.id.c2) ;
        product3 = (TextView)findViewById(R.id.c3) ;
        product1p = (TextView)findViewById(R.id.c4) ;
        product2p = (TextView)findViewById(R.id.c5) ;
        product3p = (TextView)findViewById(R.id.c6) ;

        mAuth=FirebaseAuth.getInstance();
        cobutton=(Button)findViewById(R.id.co1);
        product1.setText(getIntent().getStringExtra("item1"));
        product2.setText(getIntent().getStringExtra("item2"));
        product3.setText(getIntent().getStringExtra("item3"));
        product1p.setText(getIntent().getStringExtra("item1p"));
        product2p.setText(getIntent().getStringExtra("item2p"));
        product3p.setText(getIntent().getStringExtra("item3p"));

        String item1=  product1.getText().toString();
        String item1price=  product1p.getText().toString();
        String item2=  product2.getText().toString();
        String item2price=  product2p.getText().toString();
        String item3=  product3.getText().toString();
        String item3price=  product3p.getText().toString();

        cobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode1 = FirebaseDatabase.getInstance();
                reference1 = rootNode1.getReference("Orders").child("");


                Orderhelper orderhelperclass = new Orderhelper(item1,item1price,item2,item2price,item3,item3price);

                reference1.setValue(orderhelperclass);

            }
        });
    }
}