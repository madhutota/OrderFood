package com.itsmydu.orderfood.data.intercepters;

import okhttp3.ResponseBody;

public class UnauthorizedEvent {

    public static UnauthorizedEvent instance(ResponseBody error) {
        return new UnauthorizedEvent();
    }

    private UnauthorizedEvent() {
    }
}
