package com.example.my.sampleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.my.sampleandroid.utils.BusEventHelper;
import com.squareup.otto.Subscribe;

/**
 * Created by chers026 on 10/21/17.
 */
public class SecondLevelActivity extends AppCompatActivity implements MyFragemnt.ButtonClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new MyFragemnt());
        transaction.commit();
    }

    @Override
    public void onButtonClick() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new SecondFragment());
        transaction.commit();

        BusEventHelper.getInstance().post(new InitiateNextActivity());
    }

    public static class InitiateNextActivity {
        //No-op
    }
}
