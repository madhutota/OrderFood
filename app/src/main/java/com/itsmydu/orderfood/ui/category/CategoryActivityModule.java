package com.itsmydu.orderfood.ui.category;

import android.arch.lifecycle.ViewModelProvider;

import com.itsmydu.orderfood.data.remote.WebService;
import com.itsmydu.orderfood.di.ViewModelProviderFactory;
import com.itsmydu.orderfood.rx.SchedulersFacade;
import com.itsmydu.orderfood.ui.main.MainActivityViewModel;

import dagger.Module;
import dagger.Provides;


@Module
public class CategoryActivityModule {
    @Provides
    ViewModelProvider.Factory categoryActivityViewModelProvider(CategoryViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    CategoryViewModel provideCategotyViewModel(WebService apiService, SchedulersFacade schedulersFacade) {
        return new CategoryViewModel(apiService,schedulersFacade);
    }

}
