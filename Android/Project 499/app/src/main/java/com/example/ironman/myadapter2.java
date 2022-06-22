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

public class myadapter2 extends FirebaseRecyclerAdapter<modelshop2,myadapter2.myviewholder> {
    Context context;

    public myadapter2(@NonNull FirebaseRecyclerOptions<modelshop2> options2, Context context) {
        super(options2);
        this.context = context;

    }
    @Override
    protected void onBindViewHolder(@NonNull myadapter2.myviewholder holder, int position, @NonNull modelshop2 model)
    {
        holder.shopName.setText(model.getShopName());
        holder.address.setText(model.getAddress());
        holder.email.setText(model.getEmail());


        holder.shopName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, ShopDashboard.class);
                intent.putExtra("name",model.getShopName());
                intent.putExtra("address",model.getAddress());
                intent.putExtra("email",model.getEmail());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public myadapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        return new myadapter2.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView shopName,address,email;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            shopName=(TextView)itemView.findViewById(R.id.nametext1);
            address=(TextView)itemView.findViewById(R.id.addresstext1);
            email=(TextView)itemView.findViewById(R.id.emailtext1);
        }


    }
}
