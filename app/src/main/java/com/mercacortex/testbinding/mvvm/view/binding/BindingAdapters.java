package com.mercacortex.testbinding.mvvm.view.binding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

public class BindingAdapters {

    @BindingAdapter("bind:srcCompat")
    public static void bindImage(ImageView view, int r) {
        view.setImageResource(r);
    }

    @BindingAdapter({"bind:onClick"})
    public static void setOnClick(View view, View.OnClickListener clickListener) {
        view.setOnClickListener(clickListener);
        view.setClickable(true);
    }

}
