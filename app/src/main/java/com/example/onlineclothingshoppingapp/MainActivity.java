package com.example.onlineclothingshoppingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import adapter.ViewPageAdapter;
import fragments.LoginFragment;
import fragments.RegistrationFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabId=findViewById(R.id.tabId);
        viewPager=findViewById(R.id.viewPager);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
         adapter.addFragment(new LoginFragment(), "Login");
         adapter.addFragment(new RegistrationFragment(), "Registration");

         viewPager.setAdapter(adapter);
         tabId.setupWithViewPager(viewPager);
    }

}
