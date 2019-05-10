package com.itsmydu.orderfood.data.intercepters;

import android.content.Context;

import com.itsmydu.readme.R;

import java.io.IOException;


public class NoConnectivityException extends IOException {
    private Context context;

    public NoConnectivityException(Context context) {
        this.context = context;
    }

    @Override
    public String getMessage() {
        return context.getString(R.string.error_no_internet_connection);
    }
}
