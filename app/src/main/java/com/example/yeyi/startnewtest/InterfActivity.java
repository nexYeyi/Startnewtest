package com.example.yeyi.startnewtest;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterfActivity extends AppCompatActivity {
    private long firstPressedTime;
    private DrawerLayout mDrawerLayout;

    private Sizh[] sizhs = {new Sizh("test1",R.drawable.test1),
            new Sizh("test2",R.drawable.test2),
            new Sizh("test3",R.drawable.test3)};
    private List<Sizh> sizhList = new ArrayList<>();
    private SizhAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - firstPressedTime < 2000){
            super.onBackPressed();
        }else{
            Toast.makeText(InterfActivity.this,"再按一次返回键退出" ,Toast.LENGTH_SHORT).show();
            firstPressedTime = System.currentTimeMillis();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.daohh2);
        }
        initSizhs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SizhAdapter(sizhList);
        recyclerView.setAdapter(adapter);
    }
    private void initSizhs() {
        sizhList.clear();
        for (int i = 0; i < 5; i++){
            Random random = new Random();
            int index = random.nextInt(sizhs.length);
            sizhList.add(sizhs[index]);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
                default:
        }
        return true;
    }

}
