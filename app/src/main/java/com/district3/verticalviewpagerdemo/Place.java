package com.district3.verticalviewpagerdemo;

import android.content.Context;

/**
 * Created by chung on 4/16/16.
 */
public class Place {

    public String name;
    public String imageName;
    public boolean isFav;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }

}
