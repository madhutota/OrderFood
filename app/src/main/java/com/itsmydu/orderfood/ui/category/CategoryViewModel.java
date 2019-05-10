package com.itsmydu.orderfood.ui.category;

import android.arch.lifecycle.MutableLiveData;

import com.itsmydu.orderfood.data.Response;
import com.itsmydu.orderfood.data.remote.WebService;
import com.itsmydu.orderfood.rx.SchedulersFacade;
import com.itsmydu.orderfood.ui.base.BaseViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class CategoryViewModel extends BaseViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    private MutableLiveData<Response> categoryResponse = new MutableLiveData<>();


    public CategoryViewModel(WebService webService, SchedulersFacade schedulersFacade) {
        super(webService, schedulersFacade);
    }

    public MutableLiveData<Response> getCategoryResponse() {
        return categoryResponse;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }


    public void getMealByCategory(String categoryName) {
        disposables.add(getWebClient().getMealsByCategory(categoryName)
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
