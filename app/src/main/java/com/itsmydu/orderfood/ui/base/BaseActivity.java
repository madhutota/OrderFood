package com.itsmydu.orderfood.ui.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itsmydu.orderfood.data.intercepters.NoConnectivityEvent;
import com.itsmydu.orderfood.data.remote.ApiConstants;
import com.itsmydu.readme.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class BaseActivity extends AppCompatActivity implements ApiConstants {
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
    }

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }


    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(R.layout.activity_base, null);

        FrameLayout activityContainer = view.findViewById(R.id.activity_content_holder);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(view);
        ButterKnife.bind(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public final void onNoConnectivityEvent(NoConnectivityEvent e) {
        showNoConnectivitySnack();
    }

    private void showNoConnectivitySnack() {
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar
                .make(rootView, getString(R.string.no_internet), Snackbar.LENGTH_LONG);

        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public void showProgress() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progress_bar.setVisibility(View.GONE);
    }

}
