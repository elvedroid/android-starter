package com.elveselimoski.starterapp.util;

import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageUtil {

    private ImageUtil() {
    }

    public static void loadImage(ImageView imageView, Object o) {
        Glide.with(imageView.getContext()).load(o).into(imageView);
    }
}
