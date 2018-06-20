package com.n2soft.n2soft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.n2soft.n2soft.fragment.EventFragment;
import com.n2soft.n2soft.fragment.LikeFragment;
import com.n2soft.n2soft.fragment.MainFragment;
import com.n2soft.n2soft.fragment.MyMenuFragment;
import com.n2soft.n2soft.fragment.StampFragment;

public class MainActivity extends AppCompatActivity {

    int MAX_PAGE = 5;
    ViewPager viewPager;
    Toolbar toolbar;
    //Fragment
    Fragment fragment;
    FragmentManager fragmentManager;
    DialogFragment dialogFragment;

    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(2);
        /*ViewPager.OnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        })*/

        //mTextMessage = (TextView) findViewById(R.id.message);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        //네비게이션 기본 selected
        navigation.setSelectedItemId(R.id.navigation_home);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_stamp:
                        viewPager.setCurrentItem(2);

                        fragmentManager = getSupportFragmentManager();
                        StampFragment dialogFragment = new StampFragment();
                        dialogFragment.show(fragmentManager, "fragment_dialog_test");

                        Toast.makeText(MainActivity.this, "스탬프", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_event:
                        viewPager.setCurrentItem(1);
                        Toast.makeText(MainActivity.this, "이벤트", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(2);
                        Toast.makeText(MainActivity.this, "홈", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_favorite:
                        viewPager.setCurrentItem(3);
                        Toast.makeText(MainActivity.this, "좋아요", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_myMenu:
                        viewPager.setCurrentItem(4);
                        Toast.makeText(MainActivity.this, "마이메뉴", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });


    }

    private class adapter extends FragmentPagerAdapter {

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position<0 || MAX_PAGE<=position)
                return null;

            switch (position){
                case 0:
                    fragment = new StampFragment();
                    break;
                case 1:
                    fragment = new EventFragment();
                    break;
                case 2:
                    fragment = new MainFragment();
                    break;
                case 3:
                    fragment = new LikeFragment();
                    break;
                case 4:
                    fragment = new MyMenuFragment();
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}