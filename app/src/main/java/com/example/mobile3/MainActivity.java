package com.example.mobile3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvhero,rvHeroHorizontal;
    private ArrayList<Hero> listHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvhero = findViewById(R.id.rv_hero);
        rvHeroHorizontal = findViewById(R.id.rv_hero_horizontal);
        rvhero.setHasFixedSize(true);
        rvHeroHorizontal.setHasFixedSize(true);

        listHero.addAll(HeroesData.getListData());

        rvhero.setLayoutManager(new LinearLayoutManager(this));
        HeroAdapter heroAdapter = new HeroAdapter(listHero);
        rvhero.setAdapter(heroAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvHeroHorizontal.setLayoutManager(linearLayoutManager);
        HeroAdapterHorizontal heroAdapterHorizontal = new HeroAdapterHorizontal(listHero);
        rvHeroHorizontal.setAdapter(heroAdapterHorizontal);
    }
}
