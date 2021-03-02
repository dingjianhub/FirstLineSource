package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Button button = findViewById(R.id.button_8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FourthActivity.this, "You click the button to destroy!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("data return", "Hello Main Activity");
                setResult(RESULT_OK, intent);
                finish(); // 销毁该活动
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data return", "Hello Main Activity");
        setResult(RESULT_OK, intent);
        finish(); // 销毁该活动
    }
}
