package com.example.algomez.myuiexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements MainListAdapter.RecyclerViewClickListener {

  @BindView(R.id.main_list_recycler_view) RecyclerView mainListRecyclerView;
  MainListAdapter mainListAdapter;
  private List<ActivityItems> list;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
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
    list.add(
        new ActivityItems("Pendulum", "customized animation", PendulumActivity.getIntent(this)));
    list.add(
        new ActivityItems("Joystick", "screen with 2 joysticks", JoystickActivity.getIntent(this)));
  }

  @Override public void recyclerViewListClicked(View v, int position) {
    Intent i = list.get(position).getIntent();
    startActivity(i);
  }
}
