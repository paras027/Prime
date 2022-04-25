package com.codingstuff.customtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    EditText t1,t2;
    FirebaseAuth auth;
    TextView ftt,fgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView4);
        button =findViewById(R.id.button);
        ftt=findViewById(R.id.ft);

        ftt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(inte);
            }
        });
        fgg=findViewById(R.id.fg);
        fgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, News.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String femail = t1.getText().toString();
                String fpass = t2.getText().toString();

                if (!femail.isEmpty()) {
                    t1.setError(null);
                    if (!fpass.isEmpty()) {

                       auth = FirebaseAuth.getInstance();

                        auth.signInWithEmailAndPassword(femail, fpass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(MainActivity2.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity2.this,first.class);
                                startActivity(intent);
                            }
                        });


                    } else {
                       t1.setError("Enter Password");
                    }
                } else {
                    t2.setError("Enter Email");
                }
            }
        });
    }
}