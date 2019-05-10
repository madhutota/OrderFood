package com.itsmydu.orderfood.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import com.itsmydu.orderfood.data.remote.WebService;
import com.itsmydu.orderfood.di.ViewModelProviderFactory;
import com.itsmydu.orderfood.rx.SchedulersFacade;
import com.itsmydu.orderfood.ui.category.CategoryViewModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {
    @Provides
    ViewModelProvider.Factory mainActivityViewModelProvider(MainActivityViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    MainActivityViewModel provideAddAccountViewModel(WebService apiService, SchedulersFacade schedulersFacade) {
        return new MainActivityViewModel(apiService,schedulersFacade);
    }

}
