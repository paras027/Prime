package com.codingstuff.customtablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codingstuff.customtablayout.R;
import com.codingstuff.customtablayout.recadapter;

public class colorr extends AppCompatActivity {
    com.codingstuff.customtablayout.recadapter recadapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbbbbbb);
        recyclerView=findViewById(R.id.rv);

        LinearLayoutManager lm= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(lm);
        recadapter=new recadapter(this);
        recyclerView.setAdapter(recadapter);
    }
}