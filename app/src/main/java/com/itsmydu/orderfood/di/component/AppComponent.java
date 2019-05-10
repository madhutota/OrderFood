package com.itsmydu.orderfood.di.component;

import android.app.Application;

import com.itsmydu.orderfood.app.FoodApp;
import com.itsmydu.orderfood.di.builder.ActivityBuilder;
import com.itsmydu.orderfood.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(FoodApp application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
