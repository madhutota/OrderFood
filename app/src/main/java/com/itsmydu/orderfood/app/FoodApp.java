package com.itsmydu.orderfood.app;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;


import com.itsmydu.orderfood.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class FoodApp  extends Application implements HasActivityInjector, HasServiceInjector,HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjecter;

    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> FragmentDispatchingAndroidInjector;

   /* @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> supportfragmentInjecter;*/

    public static FoodApp mInstance;


    public static FoodApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
      //  mInstance = this;

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjecter;
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return FragmentDispatchingAndroidInjector;
    }

   /* @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return supportfragmentInjecter;
    }
*/
   /* @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return fragmentInjecter;
    }*/
}
