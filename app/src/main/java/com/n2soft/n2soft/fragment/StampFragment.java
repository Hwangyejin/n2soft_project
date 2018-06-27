package com.n2soft.n2soft.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.n2soft.n2soft.R;


public class StampFragment extends DialogFragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Create","Fragment1 Create");
        return inflater.inflate(R.layout.fragment_stamp, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

        LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();

        mBuilder.setView(mLayoutInflater.inflate(R.layout.fragment_stamp, null));

        return mBuilder.create();

    }



    @Override

    public void onStop() {

        super.onStop();

    }

    @Override
    public void onClick(View view) {

    }
}
