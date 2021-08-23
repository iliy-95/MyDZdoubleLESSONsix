package com.example.mydzdoublelessonsix;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MonthsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_months, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    // создаём список городов на экране из массива в ресурсах
    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);

        for(int i=0; i < notes.length; i++){
            String city = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(25);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPortFlora(fi);
                }
            });


        }



    }

    private void showPortFlora(int index) {
        // Откроем вторую activity
        Intent intent = new Intent();
        intent.setClass(getActivity(), FloraOrientation.class);
        // и передадим туда параметры
        intent.putExtra(FloraFragment.KEY_INDEX, index);
        startActivity(intent);
    }



}
