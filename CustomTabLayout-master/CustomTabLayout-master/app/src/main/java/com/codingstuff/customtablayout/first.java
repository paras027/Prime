package com.codingstuff.customtablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.codingstuff.customtablayout.R;

public class first extends AppCompatActivity {
    com.codingstuff.customtablayout.recadapter recadapter;
    RecyclerView recyclerView;
    TextView   ttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        ttt=findViewById(R.id.t3);
        ttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(first.this,colorr.class);
                startActivity(in);
            }
        });
        LinearLayoutManager lm= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(lm);
        recadapter=new recadapter(first.this);
        recyclerView.setAdapter(recadapter);
    }

}