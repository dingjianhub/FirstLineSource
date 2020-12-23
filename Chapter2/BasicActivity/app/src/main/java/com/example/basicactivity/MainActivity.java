package com.example.basicactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toastButton = findViewById(R.id.button_show_toast);
        toastButton.setOnClickListener((v) ->
                Toast.makeText(this, "You click the Toast Button", Toast.LENGTH_SHORT).show());

        Button destroyButton = findViewById(R.id.button_to_destroy_activity);
        destroyButton.setOnClickListener((v) -> {
            finish();
        });
    }


}