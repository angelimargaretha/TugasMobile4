package com.example.mobile3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private ArrayList<Hero> listHero;
    private Context context;

     public HeroAdapter(ArrayList<Hero> List, Context context){
        this.listHero = List;
        this.context = context;
     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(context).inflate(R.layout.item_row_hero, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
       final Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getFoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getNama());
        holder.tvDetail.setText(hero.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                Bundle bundle = new Bundle();
                bundle.putParcelable("Data",hero);
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(bundle);
                appCompatActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment,fragment,fragment.getClass().getSimpleName())
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhoto;
        private TextView tvName, tvDetail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.ivFoto);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_desc);
        }
    }
}
