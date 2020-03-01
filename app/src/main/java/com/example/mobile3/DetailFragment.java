package com.example.mobile3;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    ImageView ivFoto;
    TextView tvName,tvDesc;

    Hero heroes = new Hero();

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ivFoto  = view.findViewById(R.id.ivFoto);
        tvName = view.findViewById(R.id.tv_name);
        tvDesc = view.findViewById(R.id.tv_desc);
        Bundle bundle = this.getArguments();
        heroes = bundle.getParcelable("Data");

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName.setText(heroes.getNama());
        tvDesc.setText(heroes.getDetail());
        Glide.with(getActivity())
                .load(heroes.getFoto())
                .apply(new RequestOptions().override(200,200))
                .into(ivFoto);
    }
}
