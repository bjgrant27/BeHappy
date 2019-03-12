package com.bootisdev.behappy;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bootisdev.behappy.data.QuoteData;
import com.bootisdev.behappy.data.QuoteListAsyncResponse;
import com.bootisdev.behappy.data.QuoteViewPagerAdapter;
import com.bootisdev.behappy.model.Quote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);
    }

    private ArrayList<QuoteFragment> getFragments() {
        final ArrayList<QuoteFragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getAuthor()
                    );

                    fragmentList.add(quoteFragment);
                }

                quoteViewPagerAdapter.notifyDataSetChanged();
            }
        });

        return fragmentList;
    }
}
