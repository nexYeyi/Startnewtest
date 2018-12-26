package com.example.yeyi.startnewtest;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InInterface extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    private Sizh[] sizhs = {new Sizh("test1",R.drawable.test1),
            new Sizh("test2",R.drawable.test2)};
    private List<Sizh> sizhList = new ArrayList<>();
    private EAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_interface);
        initSizhs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
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
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

}


