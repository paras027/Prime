package com.codingstuff.customtablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText textView,textView2;
    TextView ta;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        textView=findViewById(R.id.textView3);
        textView2=findViewById(R.id.textView4);
        ta=findViewById(R.id.tt44);
        mAuth=FirebaseAuth.getInstance();

        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(inten);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = textView.getText().toString();
                String pass=textView2.getText().toString();
                if (!fname.isEmpty()) {
                    textView.setError(null);
                    if (fname.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                        if (!pass.isEmpty()) {
                            textView2.setError(null);
                            mAuth.createUserWithEmailAndPassword(fname, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplication(),"registered",Toast.LENGTH_SHORT).show();
                                        Intent in=new Intent(MainActivity.this,MainActivity2.class);
                                        startActivity(in);
                                    }
                                }
                            });
                        }
                        else{
                            textView2.setError("Enter Password");
                        }
                    }else{
                        textView.setError("Enter Valid Email ID");
                    }
                }else {
                    textView.setError("cant leave it blank");
                }
            }

        });


    }
}