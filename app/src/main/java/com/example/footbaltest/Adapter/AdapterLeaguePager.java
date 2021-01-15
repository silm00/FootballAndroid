package com.example.footbaltest.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.footbaltest.Fragments.LastMatchFragment;
import com.example.footbaltest.Fragments.NextMatchFragment;

public class AdapterLeaguePager extends FragmentStatePagerAdapter {

    int tabCount;

    String idLeague;

    public AdapterLeaguePager( FragmentManager fm, int tabCount, String idLeague) {
        //noinspection deprecation
        super(fm);
        this.tabCount=tabCount;
        this.idLeague=idLeague;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  NextMatchFragment.newInstance(idLeague);
            case 1:
                return  LastMatchFragment.newInstance(idLeague);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

