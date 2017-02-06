package com.example.kt_ki.move2live;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

import static android.R.id.tabcontent;

public class MainActivity extends FragmentActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Profile");
        tabSpec1.setContent(R.id.tab1);
//        tabSpec1.setContent(new Intent(MainActivity.this , ProfileFragment.class));
        tabSpec1.setIndicator("Profile");
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Objective");
        tabSpec2.setContent(R.id.tab2);
//        tabSpec2.setContent(new Intent(getApplicationContext() , ObjectiveFragment.class));
        tabSpec2.setIndicator("Objective");
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Community");
        tabSpec3.setContent(R.id.tab3);
//        tabSpec3.setContent(new Intent(getApplicationContext() , CommunityFragment.class));
        tabSpec3.setIndicator("Community");
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);
    }
}
