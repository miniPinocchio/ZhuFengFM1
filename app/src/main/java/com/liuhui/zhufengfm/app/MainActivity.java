package com.liuhui.zhufengfm.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.liuhui.zhufengfm.app.fragments.CustomFragment;
import com.liuhui.zhufengfm.app.fragments.DiscoverFragment;
import com.liuhui.zhufengfm.app.fragments.DownloadTingFragment;
import com.liuhui.zhufengfm.app.fragments.ProfileFragment;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private DiscoverFragment discoverFragment;
    private CustomFragment customFragment;
    private DownloadTingFragment downloadTingFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TabHost host = (TabHost) findViewById(R.id.main_tab);
//        host.setup();
//        //用于tab的区分
//        TabHost.TabSpec tab1 = host.newTabSpec("tab1");
//        tab1.setContent(R.layout.activity_splash);
//        tab1.setIndicator("扉页");
//        host.addTab(tab1);

        RadioGroup rg = (RadioGroup) findViewById(R.id.main_tab_bar);
        rg.setOnCheckedChangeListener(this);
        rg.check(R.id.main_tab_find);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = null;
        switch (checkedId){
            case R.id.main_tab_find:
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                }
                fragment = discoverFragment;
                break;
            case R.id.main_tab_custom:
                if (customFragment == null) {
                    customFragment = new CustomFragment();
                }
                fragment = customFragment;
                break;
            case R.id.main_tab_download:
                if (downloadTingFragment == null) {
                    downloadTingFragment = new DownloadTingFragment();
                }
                fragment = downloadTingFragment;
                break;
            case R.id.main_tab_profile:
                if (profileFragment == null) {
                    profileFragment = new ProfileFragment();
                }
                fragment = profileFragment;
                break;
        }
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
}
