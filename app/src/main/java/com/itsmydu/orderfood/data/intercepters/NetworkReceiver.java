package com.itsmydu.orderfood.data.intercepters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NetworkReceiver extends BroadcastReceiver {


    private final EventBus eventBus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkState.getConnectivityStatusString(context);

        // Get current time
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        String eventData = "@" + formattedDate + ": device network state: " + status;

        // Post the event with this line
        EventBus.getDefault().post(new MessageEvent(status));
    }


}
