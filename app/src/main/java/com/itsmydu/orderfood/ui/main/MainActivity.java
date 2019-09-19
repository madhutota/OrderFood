package com.itsmydu.orderfood.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itsmydu.orderfood.data.Response;
import com.itsmydu.orderfood.data.intercepters.MessageEvent;
import com.itsmydu.orderfood.data.model.Categories;
import com.itsmydu.orderfood.data.model.Meals;
import com.itsmydu.orderfood.ui.base.BaseActivity;
import com.itsmydu.orderfood.ui.category.CategoryActivity;
import com.itsmydu.readme.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;


public class MainActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    //private MainActivityViewModel mainActivityViewModel;

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerViewCategory;
    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Inject
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        ButterKnife.bind(this);

      //  mainActivityViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainActivityViewModel.class);

        mainActivityViewModel.getMeal();
        mainActivityViewModel.getCategories();


        mainActivityViewModel.getMealResponse().observe(this, this::processMealResponse);
        mainActivityViewModel.getCategoryResponse().observe(this, this::processCategoryResponse);


    }

    private void processMealResponse(Response response) {
        if (response == null)
            Response.error(getString(R.string.something_unexpected));
        switch (response.status) {
            case LOADING:
                showProgress();
                break;

            case SUCCESS:

                hideProgress();
                Meals meals = new Gson().fromJson(response.data, new TypeToken<Meals>() {
                }.getType());
                setMeal(meals.getMeals());

                break;
            case ERROR:
                hideProgress();
                break;
        }
    }

    private void processCategoryResponse(Response response) {
        if (response == null) Response.error(getString(R.string.something_unexpected));
        switch (response.status) {
            case LOADING:
                showProgress();
                break;

            case SUCCESS:
                hideProgress();
                Categories categories = gson.fromJson(response.data, new TypeToken<Categories>() {
                }.getType());
                setCategory(categories.getCategories());

                break;
            case ERROR:
                hideProgress();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void setMeal(List<Meals.Meal> meal) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(meal, this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(20, 0, 150, 0);
        headerAdapter.notifyDataSetChanged();

        headerAdapter.setOnItemClickListener((v, position) -> {
            Toast.makeText(this, meal.get(position).getStrMeal(), Toast.LENGTH_SHORT).show();
        });
    }

    public void setCategory(List<Categories.Category> category) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(category, this);
        recyclerViewCategory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(EXTRA_CATEGORY, (Serializable) category);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(MainActivity.this, event.message, Toast.LENGTH_SHORT).show();
    }



}
