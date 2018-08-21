package com.github.rubensousa.recyclerviewsnap;


import android.view.View;

import java.util.List;

public class Snap {

    private int mGravity;
    private String mText;
    private List<App> mApps;
    private View mImage;

    public Snap(int gravity, String text, List<App> apps) {
        mGravity = gravity;
        mText = text;
        mApps = apps;
    }

    public String getText(){
        return mText;
    }

    public int getGravity(){
        return mGravity;
    }

    public List<App> getApps(){
        return mApps;
    }

}
