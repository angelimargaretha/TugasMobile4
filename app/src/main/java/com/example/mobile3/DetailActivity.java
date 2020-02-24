package com.example.mobile3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ImageView ivFoto;
    TextView tvName,tvDesc;

    Hero heroes = new Hero();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivFoto  = findViewById(R.id.ivFoto);
        tvName = findViewById(R.id.tv_name);
        tvDesc = findViewById(R.id.tv_desc);

        heroes = Objects.requireNonNull(getIntent().getExtras()).getParcelable("Data");
        tvName.setText(heroes.getNama());
        tvDesc.setText(heroes.getDetail());
        Glide.with(getApplicationContext())
                .load(heroes.getFoto())
                .apply(new RequestOptions().override(200,200))
                .into(ivFoto);

    }
}
