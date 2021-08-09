package com.androidninja.mybroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ContextRegisterdReceivers contextRegisterdReceivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextRegisterdReceivers = new ContextRegisterdReceivers();
    }

    public void manifestDeclaredReceivers(View view) {
    }

    public void contextRegisterdReceivers(View view) {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(contextRegisterdReceivers, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (contextRegisterdReceivers != null)
                unregisterReceiver(contextRegisterdReceivers);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent(this,SendBroadcastReceiver.class);
        intent.setAction("sendBroadcast_Action");
        intent.putExtra("data", "Nothing to see here, move along.");
        sendBroadcast(intent);
    }

    public void LocalBroadcastManager(View view) {
      startActivity(new Intent(getApplicationContext(),LocalBroadCastManagerReceiverActivity.class));
    }
}