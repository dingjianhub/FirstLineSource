package com.example.chapter2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("data", "This is a debug log from Application Chapter 2 Demo");
        Button button_1 = (Button) findViewById(R.id.button_1);

//        // 使用 Intent 启动 SecondActivity
//        // 这里是显式地使用 Intent 不需要去修改和配置 xml 文件 -- 即在 AndroidManifest.xml 中注册 intent-filter
//        button_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 使用 toast 来显示一个简短的信息
//                Toast.makeText(MainActivity.this, "You click start button", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }
//        });


        // 使用 Intent 启动 SecondActivity
        // 这里是隐式地使用 Intent 需要去修改和配置 xml 文件 -- 在 AndroidManifest.xml 中注册 intent-filter
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用 toast 来显示一个简短的信息
                Toast.makeText(MainActivity.this, "You click start button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.chapter2.ACTION_START");
                startActivity(intent);
            }
        });

        // 隐式 Intent 用法展示,调用系统的浏览器,访问指定的网址
        Button button_4 = findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.10jqka.com.cn/"));
                startActivity(intent);
            }
        });


        // 隐式 Intent 用法展示,调用系统的拨号盘,来拨打指定的电话号码
        Button button_5 = findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button button_6 = findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello,this is some data wants transform to ThirdActivity";
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("extra", data);
                startActivity(intent);
            }
        });

        // 销毁一个活动后返回数据给上一个活动
        Button button_7 = findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式地使用 Intent 进行组件间的跳转
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                startActivityForResult(intent, 200);
            }
        });


        Button button_2 = (Button) findViewById(R.id.button_2);
        // 销毁一个活动
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You click destroy button!!!", Toast.LENGTH_LONG).show();
                finish(); // 销毁一个活动,效果和按下 back 按键一致
            }
        });


    }

    // 重写该方法,获取一个活动被销毁后,调用该活动的上一个方法的 onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 200: {
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data return");
                    Log.d("Main Activity", returnData);
                }
                break;
            }
            default: {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    // 需要 override
    // 创建出可选的菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 对于选中的 item 执行相对应的操作
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item: {
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.remove_item: {
                Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
    }
}
