package com.ruanggurutest.app.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ruanggurutest.app.android.R;
import com.ruanggurutest.app.android.base.di.component.AppComponent;
import com.ruanggurutest.app.android.base.di.component.HasComponent;
import com.ruanggurutest.app.android.base.di.module.ActivityModule;
import com.ruanggurutest.app.android.base.view.BaseImageButton;
import com.ruanggurutest.app.android.base.view.BaseTextViewMedium;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by galihadityo on 2017-09-21.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent {

    private IncludeToolbar includeToolbar;

    @BindView(R.id.toolbar)
    View toolbar;
    static class IncludeToolbar {
        @BindView(R.id.textview_toolbar)
        BaseTextViewMedium textViewToolbar;

        @BindView(R.id.button_toolbar)
        BaseImageButton buttonToolbar;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setToolbarTitle();
        initInjector();
        initial();
    }

    protected abstract void initInjector();

    private void setToolbarTitle() {
        includeToolbar = new IncludeToolbar();
        ButterKnife.bind(includeToolbar, toolbar);

        includeToolbar.textViewToolbar.setText(getToolbarTitle());
        includeToolbar.buttonToolbar.setImageResource(getButtonIconToolbar());
        includeToolbar.buttonToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToolbar();
            }
        });
    }

    @Override
    public AppComponent getComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent(new ActivityModule(this));
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) this).getComponent());
    }

    protected abstract void onClickToolbar();

    protected abstract int getButtonIconToolbar();

    protected abstract String getToolbarTitle();

    protected abstract int getLayoutId();

    protected abstract void initial();
}
