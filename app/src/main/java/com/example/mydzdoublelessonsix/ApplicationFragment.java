package com.example.mydzdoublelessonsix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ApplicationFragment extends Fragment {

    public static Fragment newInstance() {
        return new ApplicationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_application, container, false);
        return view;
    }
}
