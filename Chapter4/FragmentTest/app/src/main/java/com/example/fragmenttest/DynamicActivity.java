package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.example.fragmenttest.fragment.AnotherFragment;

/**
 * 动态加载 Fragment 的活动
 */
public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        // 1、创建待添加的碎片。
        AnotherFragment anotherFragment = new AnotherFragment();

        Button showFragmentButton = findViewById(R.id.button_to_show_fragment);
        showFragmentButton.setOnClickListener((v) -> {
            // 以 replace 的方式添加碎片
            replaceFragment(anotherFragment);

        });

        Button removeFragmentButton = findViewById(R.id.button_to_remove_fragment);
        removeFragmentButton.setOnClickListener((v) -> {
            // 移除碎片
            removeFragment(anotherFragment);
        });
    }

    /**
     * 替换 Fragment
     *
     * @param fragment 要替换的 Fragment
     */
    private void replaceFragment(Fragment fragment) {
        // 2、获取 FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 3、开始一个事务，通过 beginTransaction() 方法
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 4、向容器内添加或者替换 Fragment ，一般使用 replace 方法
        transaction.replace(R.id.frame_layout_right, fragment);
        // 5、提交事务
        transaction.commit();
    }

    /**
     * 移除 Fragment
     *
     * @param fragment 要移除的 Fragment
     */
    private void removeFragment(Fragment fragment) {
        // 2、获取 FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 3、开始一个事务，通过 beginTransaction() 方法
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 4、从容器内移除 Fragment ，使用 remove 方法
        transaction.remove(fragment);
        // 5、提交事务
        transaction.commit();
    }
}