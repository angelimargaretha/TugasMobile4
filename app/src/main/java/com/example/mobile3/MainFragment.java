package com.example.mobile3;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private RecyclerView rvhero,rvHeroHorizontal;
    private ArrayList<Hero> listHero = new ArrayList<>();
    private HeroAdapter haVertical;
    private HeroAdapterHorizontal haHorizontal;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        rvhero = view.findViewById(R.id.rv_hero);
        rvHeroHorizontal = view.findViewById(R.id.rv_hero_horizontal);
        haHorizontal = new HeroAdapterHorizontal(listHero,getActivity());
        haVertical =  new HeroAdapter(listHero,getActivity());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listHero.addAll(HeroesData.getListData());
        rvHeroHorizontal.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rvhero.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHeroHorizontal.setAdapter(haHorizontal);
        rvhero.setAdapter(haVertical);
    }
}
