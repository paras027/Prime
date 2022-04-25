package com.codingstuff.customtablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recadapter extends RecyclerView.Adapter<recadapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    public recadapter(Context mainActivity) {
        this.inflater=LayoutInflater.from(mainActivity);
    }

    @NonNull
    @Override
    public recadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reclayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recadapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        ImageView i1;
        ImageView i2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textVieww);
            i1=itemView.findViewById(R.id.imageView);
            i2=itemView.findViewById(R.id.imageView2);
        }
    }
}
