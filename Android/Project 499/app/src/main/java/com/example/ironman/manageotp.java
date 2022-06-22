package com.example.ironman;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class manageotp extends AppCompatActivity {
    private static final String TAG = "manageotp";
    EditText t1;
    EditText t2;
    Button b2;

    private String verificationId;

    FirebaseAuth mAuth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manageotp);
        verificationId = getIntent().getStringExtra("verificationId");
        t1 =(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        b2=(Button)findViewById(R.id.b22);
        mAuth=FirebaseAuth.getInstance();






        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t2.getText().toString().trim().isEmpty())
                    Toast.makeText(getApplicationContext(),"Blank Field can not be processed",Toast.LENGTH_LONG).show();
               else if(t2.getText().toString().length()!=6)
                   Toast.makeText(getApplicationContext(),"INvalid OTP",Toast.LENGTH_LONG).show();


                else
                {
                    String code = t2.getText().toString().trim();
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);
                    FirebaseAuth
                            .getInstance()
                            .signInWithCredential(credential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"WELCOME",Toast.LENGTH_LONG).show();

                                rootNode = FirebaseDatabase.getInstance();
                                reference = rootNode.getReference("users").child("");

                              String  phonenumber = getIntent().getStringExtra("phone");

                                Userhelper helperclass = new Userhelper(phonenumber);


                                Intent intent = new Intent(manageotp.this,UpdateProfile.class);
                               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                reference.setValue(helperclass);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Blank Field can not be processed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });


    }

}