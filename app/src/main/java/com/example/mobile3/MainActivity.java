package com.example.mobile3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment =  new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment,fragment,fragment.getClass().getSimpleName())
                .commit();
    }
}
