package com.n2soft.n2soft.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.n2soft.n2soft.MainActivity;
import com.n2soft.n2soft.R;


public class EventFragment extends Fragment {

    protected boolean mIsVisibleToUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Create","Fragment2 Create");

        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isResumed()) { // fragment have created
            if (mIsVisibleToUser) {
                Log.d("Event","보인다");
            } else {
                Log.d("Event","보이지 않는다");
            }
        }
    }
}
