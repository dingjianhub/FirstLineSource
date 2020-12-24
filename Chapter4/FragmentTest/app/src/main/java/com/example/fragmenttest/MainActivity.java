package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 点击按钮，跳转到动态加载 Fragment 的活动
        Button dynamicFragmentActivity = findViewById(R.id.button_dynamic_fragment_activity);
        dynamicFragmentActivity.setOnClickListener((v) ->{
            Intent intent = new Intent(this, DynamicActivity.class);
            startActivity(intent);
        });
    }
}