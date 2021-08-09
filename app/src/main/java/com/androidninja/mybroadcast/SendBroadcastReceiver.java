package com.androidninja.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SendBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = SendBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i(TAG,"action : "+action);
        switch (action) {
            case "sendBroadcast_Action":
                String data = intent.getStringExtra("data");
                Log.i(TAG,"data : "+data);
                break;
        }
    }
}