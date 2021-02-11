package com.codeinger.flowingdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FlowingDrawer mDrawer;
    private ImageView iv_Menu;
    private LinearLayout ll_Home,ll_Profile,ll_Setting,ll_Share,ll_Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replace(new HomeFragment());
        init();
    }

    private void init() {
        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        iv_Menu = findViewById(R.id.iv_Menu);
        ll_Home = findViewById(R.id.ll_Home);
        ll_Profile = findViewById(R.id.ll_Profile);
        ll_Setting = findViewById(R.id.ll_Setting);
        ll_Share = findViewById(R.id.ll_Share);
        ll_Logout = findViewById(R.id.ll_Logout);

        iv_Menu.setOnClickListener(this);
        ll_Home.setOnClickListener(this);
        ll_Profile.setOnClickListener(this);
        ll_Setting.setOnClickListener(this);
        ll_Share.setOnClickListener(this);
        ll_Logout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_Menu:
                mDrawer.openMenu(true);
                break;

            case R.id.ll_Home:
                replace(new HomeFragment(),"Home");
                mDrawer.closeMenu(true);
                break;

            case R.id.ll_Profile:
                replace(new ProfileFragment(),"Profile");
                mDrawer.closeMenu(true);
                break;

            case R.id.ll_Setting:
                replace(new SettingFragment(),"Setting");
                mDrawer.closeMenu(true);
                break;

            case R.id.ll_Share:
                Toast.makeText(this, "Share.", Toast.LENGTH_SHORT).show();
                mDrawer.closeMenu(true);
                break;

            case R.id.ll_Logout:
                Toast.makeText(this, "Logout.", Toast.LENGTH_SHORT).show();
                mDrawer.closeMenu(true);
                break;
        }
    }

    private void replace(Fragment fragment, String s) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_Main,fragment);
        transaction.addToBackStack(s);
        transaction.commit();
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_Main,fragment);
        transaction.commit();
    }

}