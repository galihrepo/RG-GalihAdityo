package com.ruanggurutest.app.android.category;

import com.ruanggurutest.app.android.category.model.CategoryModel;

import java.util.List;

/**
 * Created by galihadityo on 2017-09-21.
 */

public interface CategoryContract {

    interface View {

        List<CategoryModel> getListCategory();

    }

}
