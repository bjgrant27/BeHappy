package com.bootisdev.behappy.data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bootisdev.behappy.QuoteFragment;

import java.util.ArrayList;

public class QuoteViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<QuoteFragment> fragments;

    public QuoteViewPagerAdapter(FragmentManager fm, ArrayList<QuoteFragment> fragments) {
        super(fm);

        this.fragments = fragments;
    }

    @Override
    public QuoteFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
