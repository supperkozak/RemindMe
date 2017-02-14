package com.example.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.remindme.R;
import com.example.remindme.adapter.RemindListAdapter;
import com.example.remindme.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_history;

    public static HistoryFragment getInstance(Context context){
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new RemindListAdapter(createMockData()));
        return view;
    }

    private List<RemindDTO> createMockData() {
        List<RemindDTO> remindList = new ArrayList<>();
        remindList.add(new RemindDTO("Make something8y9oi"));
        remindList.add(new RemindDTO("Make someryuething"));
        remindList.add(new RemindDTO("Make somertuthing"));
        remindList.add(new RemindDTO("Make someewtuthing"));
        remindList.add(new RemindDTO("Make somuewrething"));
        return remindList;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

