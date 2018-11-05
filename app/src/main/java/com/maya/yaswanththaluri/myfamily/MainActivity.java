package com.maya.yaswanththaluri.myfamily;



import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private ActionBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment;

        toolBar = getSupportActionBar();
        toolBar.setTitle("Home");
        fragment = new TabOne();
        loadFragent(fragment);


        BottomNavigationView nav = (BottomNavigationView)findViewById(R.id.navview);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                switch (item.getItemId())
                {
                    case R.id.school:
                        toolBar.setTitle("School");
                        fragment = new TabThree();
                        loadFragent(fragment);
                        return true;

                    case R.id.office:
                        toolBar.setTitle("Office");
                        fragment = new TabTwo();
                        loadFragent(fragment);
                        return true;

                    case R.id.hom:
                        toolBar.setTitle("Home");
                        fragment = new TabOne();
                        loadFragent(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    public void loadFragent(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
