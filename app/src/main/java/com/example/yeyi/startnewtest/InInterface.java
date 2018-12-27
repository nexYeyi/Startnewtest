package com.example.yeyi.startnewtest;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InInterface extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    private Sizh[] sizhs = {new Sizh("test4",R.drawable.test4),
            new Sizh("test5",R.drawable.test5)};
    private List<Sizh> sizhList = new ArrayList<>();
    private EAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_interface);
        this.setTitle("申请筛查");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
        actionBar.setDisplayHomeAsUpEnabled(true);

        }
        initSizhs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler2_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EAdapter(sizhList);
        recyclerView.setAdapter(adapter);
    }
    private void initSizhs() {
        sizhList.clear();
        for (int i = 0; i < 3; i++){
            Random random = new Random();
            int index = random.nextInt(sizhs.length);
            sizhList.add(sizhs[index]);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
//              mDrawerLayout.openDrawer(GravityCompat.START);
                finish();
                break;
            default:
        }
        return true;
    }


}


