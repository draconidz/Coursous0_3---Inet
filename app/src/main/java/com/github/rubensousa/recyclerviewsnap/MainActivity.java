package com.github.rubensousa.recyclerviewsnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState == null) {
            mHorizontal = true;
        } else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }

        setupAdapter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setupAdapter() {
        //List<App> apps = getApps();
        List<App> appsSci = getAppsSci();
        List<App> appsSoc = getAppsSoc();
        List<App> appsLang = getAppsLang();
        List<App> appsTotal = getAppsTotal();
        SnapAdapter snapAdapter = new SnapAdapter();
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Science", appsSci));
            snapAdapter.addSnap(new Snap(Gravity.START, "Social", appsSoc));
            snapAdapter.addSnap(new Snap(Gravity.END, "Language", appsLang));
            //snapAdapter.addSnap(new Snap(Gravity.CENTER, "GravityPager snap", apps));
            mRecyclerView.setAdapter(snapAdapter);
        } else {
            Adapter adapter = new Adapter(false, false, appsTotal);
            mRecyclerView.setAdapter(adapter);
            new GravitySnapHelper(Gravity.TOP, false, new GravitySnapHelper.SnapListener() {
                @Override
                public void onSnap(int position) {
                    Log.d("Snapped", position + "");
                }
            }).attachToRecyclerView(mRecyclerView);
        }
    }
/*
    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("Google+", R.drawable.ic_google_48dp, 4.6f));
        apps.add(new App("Gmail", R.drawable.ic_gmail_48dp, 4.8f));
        apps.add(new App("Inbox", R.drawable.ic_inbox_48dp, 4.5f));
        apps.add(new App("Google Keep", R.drawable.ic_keep_48dp, 4.2f));
        apps.add(new App("Google Drive", R.drawable.ic_drive_48dp, 4.6f));
        apps.add(new App("Hangouts", R.drawable.ic_hangouts_48dp, 3.9f));
        apps.add(new App("Google Photos", R.drawable.ic_photos_48dp, 4.6f));
        apps.add(new App("Messenger", R.drawable.ic_messenger_48dp, 4.2f));
        apps.add(new App("Sheets", R.drawable.ic_sheets_48dp, 4.2f));
        apps.add(new App("Slides", R.drawable.ic_slides_48dp, 4.2f));
        apps.add(new App("Docs", R.drawable.ic_docs_48dp, 4.2f));
        apps.add(new App("Google+", R.drawable.ic_google_48dp, 4.6f));
        apps.add(new App("Gmail", R.drawable.ic_gmail_48dp, 4.8f));
        apps.add(new App("Inbox", R.drawable.ic_inbox_48dp, 4.5f));
        apps.add(new App("Google Keep", R.drawable.ic_keep_48dp, 4.2f));
        apps.add(new App("Google Drive", R.drawable.ic_drive_48dp, 4.6f));
        apps.add(new App("Hangouts", R.drawable.ic_hangouts_48dp, 3.9f));
        apps.add(new App("Google Photos", R.drawable.ic_photos_48dp, 4.6f));
        apps.add(new App("Messenger", R.drawable.ic_messenger_48dp, 4.2f));
        apps.add(new App("Sheets", R.drawable.ic_sheets_48dp, 4.2f));
        apps.add(new App("Slides", R.drawable.ic_slides_48dp, 4.2f));
        apps.add(new App("Docs", R.drawable.ic_docs_48dp, 4.2f));
        return apps;
    }
*/
    private List<App> getAppsSci() {
        List<App> appsSci = new ArrayList<>();
        appsSci.add(new App("Math", R.drawable.sci_math, 4.6f));
        appsSci.add(new App("Physics", R.drawable.sci_phy, 4.6f));
        appsSci.add(new App("Chemic", R.drawable.sci_chemic, 4.6f));
        appsSci.add(new App("Biology", R.drawable.sci_bio, 4.6f));
        return appsSci;
    }

    private List<App> getAppsSoc() {
        List<App> appsSoc = new ArrayList<>();
        appsSoc.add(new App("Economic", R.drawable.soc_eco, 4.6f));
        appsSoc.add(new App("Geography", R.drawable.soc_geo, 4.6f));
        appsSoc.add(new App("History", R.drawable.soc_his, 4.6f));
        return appsSoc;
    }
    private List<App> getAppsLang() {
        List<App> appsLang = new ArrayList<>();
        appsLang.add(new App("Indonesia", R.drawable.lang_ind, 4.6f));
        appsLang.add(new App("English", R.drawable.lang_eng, 4.6f));
        appsLang.add(new App("Japanese", R.drawable.lang_jap, 4.6f));
        appsLang.add(new App("France", R.drawable.lang_fran, 4.6f));
        return appsLang;
    }
    private List<App> getAppsTotal(){
        List<App> appsTotal = new ArrayList<>();
        appsTotal.add(new App("Math", R.drawable.sci_math, 4.6f));
        appsTotal.add(new App("Physics", R.drawable.sci_phy, 4.6f));
        appsTotal.add(new App("Chemic", R.drawable.sci_chemic, 4.6f));
        appsTotal.add(new App("Biology", R.drawable.sci_bio, 4.6f));
        appsTotal.add(new App("Economic", R.drawable.soc_eco, 4.6f));
        appsTotal.add(new App("Geography", R.drawable.soc_geo, 4.6f));
        appsTotal.add(new App("History", R.drawable.soc_his, 4.6f));
        appsTotal.add(new App("Indonesia", R.drawable.lang_ind, 4.6f));
        appsTotal.add(new App("English", R.drawable.lang_eng, 4.6f));
        appsTotal.add(new App("Japanese", R.drawable.lang_jap, 4.6f));
        appsTotal.add(new App("France", R.drawable.lang_fran, 4.6f));
        return appsTotal;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.layoutType) {
            mHorizontal = !mHorizontal;
            setupAdapter();
            item.setTitle(mHorizontal ? "Vertical" : "Horizontal");
        } else if (item.getItemId() == R.id.grid) {
            startActivity(new Intent(this, GridActivity.class));
        }
        return false;
    }
}
