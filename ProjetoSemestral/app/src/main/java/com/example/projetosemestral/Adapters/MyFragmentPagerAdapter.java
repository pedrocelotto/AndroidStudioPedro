package com.example.projetosemestral.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projetosemestral.Fragments.FragmentBalada;
import com.example.projetosemestral.Fragments.FragmentBar;
import com.example.projetosemestral.Fragments.FragmentRestaurantes;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentRestaurantes();
            case 1:
                return new FragmentBar();
            case 2:
                return new FragmentBalada();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
