package com.example.remindme.adapter;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.remindme.R;
import com.example.remindme.fragment.AbstractTabFragment;
import com.example.remindme.fragment.BirthdaysFragment;
import com.example.remindme.fragment.IdeasFragment;
import com.example.remindme.fragment.NotificationFragment;
import com.example.remindme.fragment.StotyFragment;
import com.example.remindme.fragment.TodoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initMap(context);
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    private void initMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, NotificationFragment.getInstance(context));
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, StotyFragment.getInstance(context));
        tabs.put(4, BirthdaysFragment.getInstance(context));
    }
}
