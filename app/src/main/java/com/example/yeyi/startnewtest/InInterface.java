package com.example.yeyi.startnewtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InInterface extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton mButton;
    private TextView huadon;

//    private List<Sizh> sizhList = new ArrayList<>();
//    private SizhAdapter adapter;

//    private Sizh[] sizhs = {new Sizh("test4", R.drawable.test4),
//            new Sizh("test5", R.drawable.test5)};
public static final String SIZH_NAME = "sizh_name";
    public static final String SIZH_IMAGE_ID = "sizh_image_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_interface);
        Button finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InInterface.this,ApplyActivity.class);
                startActivity(intent);
            }
        });
        huadon = (TextView) findViewById(R.id.huadon);
        huadon.setOnTouchListener(touchListener);
        huadon.setMovementMethod(ScrollingMovementMethod.getInstance());

        mButton = (FloatingActionButton) findViewById(R.id.shouzhi);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InInterface.this,ApplyActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String sizhName = intent.getStringExtra(SIZH_NAME);
        int sizhImageId = intent.getIntExtra(SIZH_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView sizhImageView = (ImageView) findViewById(R.id.sizh_image_view);
        TextView sizhContentText = (TextView) findViewById(R.id.sizh_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(sizhName);
        Glide.with(this).load(sizhImageId).into(sizhImageView);
        String sizhContent = generateSizhContent(sizhName);
        sizhContentText.setText(sizhContent);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NestedScrollView nestedScrollView = findViewById(R.id.bighuadong);
                nestedScrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        nestedScrollView.fullScroll(NestedScrollView.FOCUS_UP);
                    }
                });
            }
        });
    }


    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN
                    || event.getAction() == MotionEvent.ACTION_MOVE){
                //按下或滑动时请求父节点不拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(true);
            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                //抬起时请求父节点拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    };


    private String generateSizhContent(String sizhName) {
        StringBuilder sizhContent = new StringBuilder();
        for(int i = 0; i < 500 ; i++){
            sizhContent.append(sizhName);
        }
        return sizhContent.toString();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
