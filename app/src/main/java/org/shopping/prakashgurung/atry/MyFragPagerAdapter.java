package org.shopping.prakashgurung.atry;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by prakashgurung on 1/8/17.
 */

public class MyFragPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> pages = new ArrayList<>();



    public MyFragPagerAdapter (FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    public void addPage(Fragment f){
        pages.add(f);
    }

    public CharSequence getPageTitle(int position){
        return pages.get(position).toString();



    }



}
