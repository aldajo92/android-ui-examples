package com.example.algomez.myuiexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.algomez.myuiexamples.ui.DelayedViewActivity;
import com.example.algomez.myuiexamples.ui.expandableitem.ExpandableItemActivity;
import com.example.algomez.myuiexamples.ui.pendulum.PendulumActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainListAdapter.RecyclerViewClickListener {

    @BindView(R.id.main_list)
    RecyclerView mainListRecyclerView;
    MainListAdapter mainListAdapter;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initList();
        initRecyclerView();
    }

    public void initRecyclerView() {
        mainListAdapter = new MainListAdapter(list, this);
        mainListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainListRecyclerView.setAdapter(mainListAdapter);
    }

    public void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item " + i);
        }
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Intent i;
        switch (position) {
            case 0:
                i = PendulumActivity.getIntent(this);
                startActivity(i);
                break;
            case 1:
                i = ExpandableItemActivity.getIntent(this);
                startActivity(i);
                break;
            case 2:
                i = DelayedViewActivity.getIntent(this);
                startActivity(i);
                break;
        }
    }
}
