package com.example.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.remindme.R;
import com.example.remindme.adapter.RemindListAdapter;
import com.example.remindme.dto.User;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_history;

    private List<User>data;

    RemindListAdapter adapter;

    public static HistoryFragment  getInstance(Context context, List<User> userList){
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_history));
        fragment.setList(userList);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RemindListAdapter(data);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<User> createMockData() {
        List<User> remindList = new ArrayList<>();
        remindList.add(new User("Make something8y9oi","try"));
        return remindList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setList(List<User> list) {
        this.data = list;
    }

    public void refreshData(List<User>list){
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }
}

