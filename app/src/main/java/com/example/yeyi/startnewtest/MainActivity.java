package com.example.yeyi.startnewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long firstPressedTime;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - firstPressedTime < 2000){
            super.onBackPressed();
        }else{
            Toast.makeText(MainActivity.this,"再按一次返回键退出" ,Toast.LENGTH_SHORT).show();
            firstPressedTime = System.currentTimeMillis();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView zhuce = (TextView) findViewById(R.id.link_signup);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });


    }
}
