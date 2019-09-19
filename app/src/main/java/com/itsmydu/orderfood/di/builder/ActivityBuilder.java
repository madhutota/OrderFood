package com.itsmydu.orderfood.di.builder;

import com.itsmydu.orderfood.ui.category.CategoryActivity;
import com.itsmydu.orderfood.ui.category.CategoryActivityModule;
import com.itsmydu.orderfood.ui.category.CategoryFragment;
import com.itsmydu.orderfood.ui.main.MainActivity;
import com.itsmydu.orderfood.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {CategoryActivityModule.class})
    abstract CategoryActivity bindCategoryActivity();

    @ContributesAndroidInjector(modules = {CategoryActivityModule.class})
    abstract CategoryFragment bindCategoryFragment();
}
