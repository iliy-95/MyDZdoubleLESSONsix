package com.example.mydzdoublelessonsix;



import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FloraFragment extends Fragment {

    public static final String KEY_INDEX = "index";
    //private static final String KEY_INDEX = ;
    private int index;



    public static FloraFragment newInstance(int index){
      FloraFragment f = new FloraFragment();

      Bundle keys = new Bundle();
      keys.putInt(KEY_INDEX,index);
      f.setArguments(keys);
      return f;
  }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            index = getArguments().getInt(KEY_INDEX);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flora, container, false);

        AppCompatImageView imageflora = view.findViewById(R.id.imgeNotes);
        TypedArray flora_a = getResources().obtainTypedArray(R.array.flora_a);
        imageflora.setImageResource(flora_a.getResourceId(index, -1));
        return view;



    }
}




