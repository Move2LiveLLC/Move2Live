package com.example.kt_ki.move2live;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TabHost;

public class TabActivity extends FragmentActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Profile");
        tabSpec1.setContent(R.id.tab1);
//        tabSpec1.setContent(new Intent(TabActivity.this , ProfileFragment.class));
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

//        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("MyBlog");
//        tabSpec4.setContent(R.id.tab4);
////        tabSpec3.setContent(new Intent(getApplicationContext() , CommunityFragment.class));
//        tabSpec4.setIndicator("MyBlog");
//        tabHost.addTab(tabSpec4);

        tabHost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Setting");
        return super.onCreateOptionsMenu(menu);
    }
}
