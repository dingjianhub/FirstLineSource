package com.example.broadcastbestpractice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.example.broadcastbestpractice.LoginActivity;
import com.example.broadcastbestpractice.util.ActivityCollector;

public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("You are forced t offline, please try to login again");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 销毁所有的活动
                ActivityCollector.finishAll();
                Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                context.startActivity(intent);
            }
        });
        builder.show();
    }
}
