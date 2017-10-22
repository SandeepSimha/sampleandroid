package com.example.my.sampleandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.my.sampleandroid.utils.BusEventHelper;
import com.squareup.otto.Subscribe;

/**
 * Created by chers026 on 10/22/17.
 */
public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataGotFromOtto(new SecondLevelActivity.InitiateNextActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        BusEventHelper.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusEventHelper.getInstance().unregister(this);
    }

    @Subscribe
    public void onDataGotFromOtto(SecondLevelActivity.InitiateNextActivity event) {
        Toast.makeText(getContext(), "Got data", Toast.LENGTH_SHORT).show();

    }
}
