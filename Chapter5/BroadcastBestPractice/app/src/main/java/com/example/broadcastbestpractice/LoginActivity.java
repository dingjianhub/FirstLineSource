package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcastbestpractice.util.BaseActivity;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEdit = findViewById(R.id.edit_text_account);
        passwordEdit = findViewById(R.id.edit_text_password);
        loginButton = findViewById(R.id.button_login_account);

        loginButton.setOnClickListener((v) -> {
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if (TextUtils.equals(account, "admin") && TextUtils.equals(password, "123")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}