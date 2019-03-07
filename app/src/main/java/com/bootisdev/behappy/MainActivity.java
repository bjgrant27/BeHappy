package com.bootisdev.behappy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bootisdev.behappy.data.QuoteData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QuoteData().getQuotes();
    }
}
