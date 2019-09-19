package com.itsmydu.orderfood.app;

import com.itsmydu.orderfood.di.component.AppComponent;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
/*
public class FoodAppDaggerApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}*/
