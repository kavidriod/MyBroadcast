package com.androidninja.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ContextRegisterdReceivers extends BroadcastReceiver {

    private static final String TAG = ContextRegisterdReceivers.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive "+intent.getAction());
    }
}