package com.itsmydu.orderfood.ui.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.itsmydu.orderfood.data.remote.WebService;
import com.itsmydu.orderfood.rx.SchedulersFacade;

public class BaseViewModel extends ViewModel {

   /* private WeakReference<T> mNavigator;*/
    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();
    private WebService webClient;
    private SchedulersFacade schedulersFacade ;


    public BaseViewModel(WebService webService, SchedulersFacade schedulersFacade) {
        this.webClient = webService;
        this.schedulersFacade = schedulersFacade;
    }

    public WebService getWebClient() {
        return webClient;
    }

    public SchedulersFacade getSchedulersFacade() {
        return schedulersFacade;
    }

   /* public T getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(T navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
*/
    public LiveData<Boolean> getmIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.setValue(isLoading);
    }

}
