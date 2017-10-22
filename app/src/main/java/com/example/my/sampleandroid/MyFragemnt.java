package com.example.my.sampleandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.my.sampleandroid.utils.BusEventHelper;

/**
 * Created by chers026 on 10/22/17.
 */
public class MyFragemnt extends Fragment {

    private ButtonClickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener) {
            listener = (ButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SlidingUpDashboardListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_level, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Button button = view.findViewById(R.id.buttonPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onButtonClick();
            }
        });*/
    }


    public interface ButtonClickListener {
        void onButtonClick();
    }
}
