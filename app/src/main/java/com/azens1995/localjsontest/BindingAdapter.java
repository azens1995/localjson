package com.azens1995.localjsontest;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Azens Eklak on 2019-06-14.
 * Ishani Technology Pvt. Ltc
 * azens1995@gmail.com
 */
public class BindingAdapter {

    @androidx.databinding.BindingAdapter({"photo"})
    public static void setImage(ImageView image, String photo){
        Picasso.get().load(photo).into(image);
    }
}
