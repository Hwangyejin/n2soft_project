package com.n2soft.n2soft;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.n2soft.n2soft.fragment.EventFragment;
import com.n2soft.n2soft.fragment.LikeFragment;
import com.n2soft.n2soft.fragment.MainFragment;
import com.n2soft.n2soft.fragment.MyMenuFragment;
import com.n2soft.n2soft.fragment.StampFragment;

public class MainActivity extends AppCompatActivity {
    int MAX_PAGE = 5;
    Toolbar toolbar;
    //Fragment
    FragmentManager fragmentManager;
    DrawerLayout dlDrawer;
    ActionBarDrawerToggle dtToggle;

    Fragment fragment;
    private BottomNavigationView navigation;
    StampFragment dialogFragment;
    ViewPager viewPager;
    FrameLayout frameLayout;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*툴바*/
        toolbar = findViewById(R.id.toolbar);
        //dlDrawer =(DrawerLayout)findViewById(R.id.drawer_layout);

        //toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*drawer*/
        /*dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.string.app_name, R.string.app_name);
        dlDrawer.addDrawerListener(dtToggle);*/

        /*nvigation*/
        fragmentManager = getSupportFragmentManager();
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(navigation);

        //네비게이션 기본 selected
        navigation.setSelectedItemId(R.id.navigation_home);

        //네비게이션 item 클릭
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_stamp:

                        dialogFragment = new StampFragment();
                        dialogFragment.show(fragmentManager, "fragment_dialog_test");

                        Toast.makeText(MainActivity.this, "스탬프", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_event:
                        fragment = new EventFragment();
                        Toast.makeText(MainActivity.this, "이벤트", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_home:
                        fragment = new MainFragment();
                        Toast.makeText(MainActivity.this, "홈", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_favorite:
                        fragment = new LikeFragment();
                        Toast.makeText(MainActivity.this, "좋아요", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_myMenu:
                        fragment = new MyMenuFragment();
                        Toast.makeText(MainActivity.this, "마이메뉴", Toast.LENGTH_SHORT).show();
                        break;
                }
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainView, fragment).commit();
                return true;
            }
        });


    }



}