package com.example.algomez.myuiexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.algomez.myuiexamples.generic.AbstractItemView;
import com.example.algomez.myuiexamples.generic.ClickItemView;
import com.example.algomez.myuiexamples.generic.GenericItemView;
import com.example.algomez.myuiexamples.generic.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_list)
    RecyclerView mainListRecyclerView;
    MainListAdapter mainListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecyclerView();
        initList();
    }

    public void initRecyclerView() {
        mainListAdapter = new MainListAdapter(null);
        mainListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainListRecyclerView.setAdapter(mainListAdapter);
    }

    public void initList() {
        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.HEADER_ITEM));
        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        mainListAdapter.addItem(new ClickItemView("Text", () -> android.util.Log.i("ADJ", "Message")));

        List<GenericItemView> carouselItems = new ArrayList<>();

        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        carouselItems.add(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));

        mainListAdapter.addItem(new AbstractItemView<>(carouselItems, MainListAdapter.CARROUSEL_ITEM));

        List<GenericItemView> otherCarouselItems = new ArrayList<>();

        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));
        otherCarouselItems.add(new AbstractItemView<>("Cosa", MainListAdapter.SINGLE_ITEM));

        mainListAdapter.addItem(new AbstractItemView<>(otherCarouselItems, MainListAdapter.CARROUSEL_ITEM));

        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));
        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.HEADER_ITEM));
        mainListAdapter.addItem(new AbstractItemView<>("Hola", MainListAdapter.SINGLE_ITEM));

    }

//    @Override
//    public void recyclerViewListClicked(View v, int position) {
//        Intent i;
//        switch (position) {
//            case 0:
//                i = PendulumActivity.getIntent(this);
//                startActivity(i);
//                break;
//            case 1:
//                i = ExpandableItemActivity.getIntent(this);
//                startActivity(i);
//                break;
//            case 2:
//                i = DelayedViewActivity.getIntent(this);
//                startActivity(i);
//                break;
//        }
//    }
}
