package com.example.touki.calculator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Broadcast Recieved",Toast.LENGTH_LONG).show();
        Intent i = new Intent();
        i.setClassName("com.example.touki.calculator", "com.example.touki.calculator.MainActivity");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
