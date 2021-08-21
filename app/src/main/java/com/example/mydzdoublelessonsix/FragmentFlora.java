package com.example.mydzdoublelessonsix;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

public class FragmentFlora extends Activity implements FragmentFlora1 {

    public static final String ARG_INDEX = "index";
    private int index;
    private Bundle arguments;
    private ViewGroup linearLayout;
    private Context context;

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы.
    public static FragmentFlora newInstance(int index) {
        FragmentFlora f = new FragmentFlora();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Таким способом можно получить головной элемент из макета
        View view = inflater.inflate(R.layout.fragment_flora, container, false);
        // найти в контейнере элемент-изображение
        AppCompatImageView imageCoatOfArms = view.findViewById(R.id.florataim);
        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray images = getResources().obtainTypedArray(R.array.flora_a);
        String[] flora = getResources().getStringArray(R.array.flora_a);
        // Выбрать по индексу подходящий
        imageCoatOfArms.setImageResource(images.getResourceId(index, -1));
        return view;
        /*for(int i =0;i<flora.length;i++){
            String name = flora[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCoatOfArms(finalI);
                }
            });
        }

        return view;*/

    }

    private void showCoatOfArms(int finalI) {

    }


    public void setArguments(Bundle arguments) {
        this.arguments = arguments;
    }

    public Bundle getArguments() {
        return arguments;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
