package com.itsmydu.orderfood.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.itsmydu.orderfood.data.Status.ERROR;
import static com.itsmydu.orderfood.data.Status.LOADING;
import static com.itsmydu.orderfood.data.Status.SUCCESS;


public class Response {
    public final Status status;

    @Nullable
    public final String data;

    @Nullable
    public final String error;

    public Response(Status status, @Nullable String data, @Nullable String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull String data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull String error) {
        return new Response(ERROR, null, error);
    }
}
