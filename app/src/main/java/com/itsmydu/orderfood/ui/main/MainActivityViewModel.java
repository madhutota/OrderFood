package com.itsmydu.orderfood.ui.main;

import android.arch.lifecycle.MutableLiveData;

import com.itsmydu.orderfood.data.Response;
import com.itsmydu.orderfood.data.remote.WebService;
import com.itsmydu.orderfood.rx.SchedulersFacade;
import com.itsmydu.orderfood.ui.base.BaseViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityViewModel extends BaseViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    private MutableLiveData<Response> mealResponse = new MutableLiveData<>();
    private MutableLiveData<Response> categoryResponse = new MutableLiveData<>();

    MainActivityViewModel(WebService webService, SchedulersFacade schedulersFacade) {
        super(webService, schedulersFacade);
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    public MutableLiveData<Response> getMealResponse() {
        return mealResponse;
    }public MutableLiveData<Response> getCategoryResponse() {
        return categoryResponse;
    }

    public void getMeal() {
        disposables.add(getWebClient().getMeal()
                .subscribeOn(getSchedulersFacade().io())
                .observeOn(getSchedulersFacade().ui())
                .doOnSubscribe(__ -> mealResponse.setValue(Response.loading()))
                .subscribe(
                        greeting -> mealResponse.setValue(Response.success(greeting.toString())),
                        throwable -> mealResponse.setValue(Response.error(throwable.getMessage()))
                )
        );


    }

    public void getCategories() {
        disposables.add(getWebClient().getCategories()
                .subscribeOn(getSchedulersFacade().io())
                .observeOn(getSchedulersFacade().ui())
                .doOnSubscribe(__ -> categoryResponse.setValue(Response.loading()))
                .subscribe(
                        greeting -> categoryResponse.setValue(Response.success(greeting.toString())),
                        throwable -> categoryResponse.setValue(Response.error(throwable.getMessage()))
                )
        );


    }




}
