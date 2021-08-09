package com.androidninja.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.androidninja.mybroadcast.databinding.ActivityLocalBroadCastManagerReceiverBinding;

public class LocalBroadCastManagerReceiverActivity extends AppCompatActivity {

    private static final String TAG = LocalBroadCastManagerReceiverActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broad_cast_manager_receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(broadcastReceiver,new IntentFilter("LocalBroadCast_Action"));
    }

    public void SendLocalBroadcast(View view) {
            Intent intent = new Intent();
            intent.putExtra("data","local broadcast data");
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals("LocalBroadCast_Action"))
            {
                String message = intent.getStringExtra("data");
                Log.i(TAG,"message "+message);
            }
            else
            {
                Log.i(TAG,"No action Found");
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}