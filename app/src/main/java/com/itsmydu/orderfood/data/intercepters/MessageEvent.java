package com.itsmydu.orderfood.data.intercepters;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class MessageEvent {

    private PublishSubject<LatLng> subject = PublishSubject.create();

    public void setLocation(LatLng latLng) {
        subject.onNext(latLng);
    }

    public Observable<LatLng> getUserLocation() {
        return subject;
    }



    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }
}
