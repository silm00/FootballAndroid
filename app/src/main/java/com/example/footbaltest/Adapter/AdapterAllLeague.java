package com.example.footbaltest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbaltest.R;
import com.example.footbaltest.Activity.LeagueDetailActivity;
import com.example.footbaltest.Model.CountrysItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAllLeague extends RecyclerView.Adapter<AdapterAllLeague.ViewHolder> {

    Context context;
    List<CountrysItem> items;

    public AdapterAllLeague(Context context, List<CountrysItem> items) {
        this.context = context;
        this.items = items;
    }

    public void setItems(List<CountrysItem> items) {

        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_league,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNama.setText(items.get(position).getStrLeague());

        Picasso.get()
                .load(items.get(position).getStrBadge())
                .resize(200,200)
                .into(holder.ivLogo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LeagueDetailActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("id",items.get(position).getIdLeague());
                mBundle.putString("nama",items.get(position).getStrLeague());
                mBundle.putString("logo",items.get(position).getStrBadge());
                mBundle.putString("keterangan",items.get(position).getStrCountry());
                intent.putExtras(mBundle);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLogo;
        TextView tvNama;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivLogo=itemView.findViewById(R.id.ivLogo);
            tvNama=itemView.findViewById(R.id.tvNama);

            this.itemView=itemView;
        }
    }



}

