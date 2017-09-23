package com.ruanggurutest.app.android.category;

import android.support.v7.widget.GridLayoutManager;

import com.ruanggurutest.app.android.R;
import com.ruanggurutest.app.android.R2;
import com.ruanggurutest.app.android.base.BaseActivity;
import com.ruanggurutest.app.android.base.view.BaseRecycleView;
import com.ruanggurutest.app.android.category.adapter.CategoryAdapter;
import com.ruanggurutest.app.android.category.model.CategoryModel;
import com.ruanggurutest.app.android.game.di.DaggerGameComponent;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

public class CategoryActivity extends BaseActivity implements CategoryContract.View {

    @BindView(R.id.recycle_view)
    BaseRecycleView recycleView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initial() {
        setupRecycleView();
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void onClickToolbar() {
        onBackPressed();
    }

    @Override
    protected int getButtonIconToolbar() {
        return R.drawable.arrow_back;
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.toolbar_title_category);
    }

    private void setupRecycleView() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getListCategory());

        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        recycleView.setAdapter(categoryAdapter);

    }

    @Override
    public List<CategoryModel> getListCategory() {
        List<CategoryModel> categoryModelList = new LinkedList<>();

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_general,
                        R.drawable.general,
                        getString(R.string.category_general),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_book,
                        R.drawable.book,
                        getString(R.string.category_general),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_film,
                        R.drawable.film,
                        getString(R.string.category_film),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_music,
                        R.drawable.music,
                        getString(R.string.category_music),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_game,
                        R.drawable.game,
                        getString(R.string.category_game),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_tv,
                        R.drawable.tv,
                        getString(R.string.category_tv),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_computer,
                        R.drawable.computer,
                        getString(R.string.category_computer),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_celeb,
                        R.drawable.star,
                        getString(R.string.category_celeb),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_history,
                        R.drawable.history ,
                        getString(R.string.category_history),
                        15)
        );

        categoryModelList.add(
                new CategoryModel(
                        R.drawable.category_animal,
                        R.drawable.combined_shape,
                        getString(R.string.category_animal),
                        15)
        );

        return categoryModelList;
    }
}
