package com.ruanggurutest.app.android.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.ruanggurutest.app.android.R;
import com.ruanggurutest.app.android.base.helper.Screen;
import com.ruanggurutest.app.android.base.view.BaseImageView;
import com.ruanggurutest.app.android.base.view.BaseTextViewRegular;
import com.ruanggurutest.app.android.category.model.CategoryModel;
import com.ruanggurutest.app.android.game.GameActivity;

import java.util.List;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CategoryModel> categoryModelList;

    public CategoryAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CategoryModel categoryModel = categoryModelList.get(position);

        ((CategoryViewHolder)holder).icon.setImageResource(categoryModel.getIcon());
        ((CategoryViewHolder)holder).title.setText(categoryModel.getTitle());
        ((CategoryViewHolder)holder).rippleView
                .setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = GameActivity.getCallingIntent((AppCompatActivity) context,
                        categoryModel.getCategory(),
                        categoryModel.getTitle());
                context.startActivity(intent);
            }
        });

        int width = Screen.getWidth(context)/2;
        Glide.with(context)
                .load(categoryModel.getBackground())
                .fitCenter()
                .override(width, Target.SIZE_ORIGINAL)
                .into(((CategoryViewHolder)holder).background);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        public BaseImageView background;
        public BaseImageView icon;
        public BaseTextViewRegular title;
        public RippleView rippleView;

        public CategoryViewHolder(View view) {
            super(view);

            rippleView = view.findViewById(R.id.ripple_view);
            background = view.findViewById(R.id.iv_background);
            icon = view.findViewById(R.id.iv_icon);
            title = view.findViewById(R.id.tv_title);
        }
    }
}
