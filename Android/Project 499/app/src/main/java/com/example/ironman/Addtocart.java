package com.example.ironman;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addtocart extends AppCompatActivity {
    EditText e11;
    EditText e12;
    EditText e13;
    EditText e14;
    EditText e21;
    EditText e22;
    EditText e23;
    EditText e24;
    EditText e31;
    EditText e32;
    EditText e33;
    EditText e34;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    Button badd1;
    Button badd2;
    Button badd3;
    Button adall;
    TextView total;
    Button checkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        e11= (EditText) findViewById(R.id.PI1);
        e12= (EditText) findViewById(R.id.PI2);
        e13= (EditText) findViewById(R.id.PI3);
        e14= (EditText) findViewById(R.id.PN1);
        e21= (EditText) findViewById(R.id.PN2);
        e22= (EditText) findViewById(R.id.PN3);
        e23= (EditText) findViewById(R.id.QN1);
        e24= (EditText) findViewById(R.id.QN2);
        e31= (EditText) findViewById(R.id.QN3);
        e32= (EditText) findViewById(R.id.PR1);
        e33= (EditText) findViewById(R.id.PR2);
        e34= (EditText) findViewById(R.id.PR3);
        tv1= (TextView) findViewById(R.id.TT1);
        tv2= (TextView) findViewById(R.id.TT2);
        tv3= (TextView) findViewById(R.id.TT3);
        badd1= (Button) findViewById(R.id.ad1);
        badd2= (Button) findViewById(R.id.ad2);
        badd3= (Button) findViewById(R.id.ad3);
        adall=(Button) findViewById(R.id.addall) ;
        total = (TextView)findViewById(R.id.TOTAL) ;
        checkout = (Button) findViewById(R.id.checkout) ;
        badd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,b,c;
                a = Double.parseDouble(e23.getText().toString());
                b = Double.parseDouble(e32.getText().toString());
                c= a*b;
                tv1.setText(Double.toString(c));
            }
        });
        badd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double e,f,g;
                e = Double.parseDouble(e24.getText().toString());
                f = Double.parseDouble(e33.getText().toString());
                g= e*f;
                tv2.setText(Double.toString(g));
            }
        });
badd3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        double i,j,k;
        i = Double.parseDouble(e31.getText().toString());
        j = Double.parseDouble(e34.getText().toString());
        k= i*j;
        tv3.setText(Double.toString(k));
    }
});
adall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        double m,n,o,p;
        m = Double.parseDouble(tv1.getText().toString());
        n = Double.parseDouble(tv2.getText().toString());
        o = Double.parseDouble(tv3.getText().toString());
        p= m+n+o;
        total.setText(Double.toString(p));
    }
});
checkout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Addtocart.this, Checkout.class);
        intent.putExtra("item1",e14.getText().toString());
        intent.putExtra("item2",e21.getText().toString());
        intent.putExtra("item3",e22.getText().toString());
        intent.putExtra("item1p",tv1.getText().toString());
        intent.putExtra("item2p",tv2.getText().toString());
        intent.putExtra("item3p",tv3.getText().toString());
        intent.putExtra("itemtotal",total.getText().toString());

        startActivity(intent);
    }
});

    }
}