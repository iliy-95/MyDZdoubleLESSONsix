package com.example.mydzdoublelessonsix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity_two extends AppCompatActivity {

    private Bundle arguments;
    private Fragment newInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если эта activity запускается первый раз (с каждым новым гербом первый раз),
            // то перенаправим параметр фрагменту
            MainActivity_two fl = new MainActivity_two();
            fl.setArguments(getIntent().getExtras());
            // Добавим фрагмент на activity
            switch (getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fl.newInstance ).commit()) {

            }
        }
    }


    public void setArguments(Bundle arguments) {
        this.arguments = arguments;
    }

    public Bundle getArguments() {
        return arguments;
    }
}
