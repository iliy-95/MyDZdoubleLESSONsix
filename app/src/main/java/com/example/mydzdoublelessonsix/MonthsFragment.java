package com.example.mydzdoublelessonsix;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MonthsFragment extends Fragment {

    public static final String CURRENT_MONTHS = "CurrentMonths";
    private int currentPosition = 0;    // Текущая позиция (выбранный город)
    private boolean isLandscape;

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

        for (int i = 0; i < notes.length; i++) {
            String city = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(25);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //showPortFlora(fi);
                    currentPosition = fi;
                    showFlora(currentPosition);
                }
            });


        }


    }
    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    //@Override
   // public void onSaveInstanceState( Bundle outState) {
       // outState.putInt(CURRENT_MONTHS, currentPosition);
        //super.onSaveInstanceState(outState);
    //}
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_MONTHS,currentPosition);
        super.onSaveInstanceState(outState);
    }


    //activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        // Если это не первое создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentPosition = savedInstanceState.getInt(CURRENT_MONTHS, 0);
        }



// Если можно нарисовать рядом герб, то сделаем это
        if (isLandscape) {
            showLandFlora(currentPosition);
        }

    }
        private void showFlora ( int index){
            if (isLandscape) {
                showLandFlora(index);
            } else {
                showPortFlora(index);
            }
        }

        // Показать герб в ландшафтной ориентации
        private void showLandFlora ( int index){
            // Создаём новый фрагмент с текущей позицией для вывода герба
            FloraFragment detail = FloraFragment.newInstance(index);

            // Выполняем транзакцию по замене фрагмента
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.imgeNotes, detail);  // замена фрагмента
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }




    private void showPortFlora ( int index){
            // Откроем вторую activity
            Intent intent = new Intent();
            intent.setClass(getActivity(), FloraOrientation.class);
            // и передадим туда параметры
            intent.putExtra(FloraFragment.KEY_INDEX, index);
            startActivity(intent);
        }



}


