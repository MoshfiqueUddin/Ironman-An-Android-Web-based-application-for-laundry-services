package com.example.ironman;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class itemadapter extends FirebaseRecyclerAdapter<itemhelper,itemadapter.myviewholder> {
    Context context;
    public itemadapter(@NonNull FirebaseRecyclerOptions<itemhelper> options3, Context context) {
        super(options3);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull itemhelper model)
    {
        holder.itemname.setText(model.getItemname());
        holder.itemprice.setText(model.getItemprice());


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow3,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView itemname,itemprice;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            itemname=(TextView)itemView.findViewById(R.id.itemname1);
            itemprice=(TextView)itemView.findViewById(R.id.itemprice2);
        }
    }
}
