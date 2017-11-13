package com.example.algomez.myuiexamples.generic;

import com.example.algomez.myuiexamples.MainListAdapter;

public class ClickItemView implements GenericItemView<String> {

    private String data;
    private RecyclerViewClickListener listener;

    public ClickItemView(String  data, RecyclerViewClickListener listener){
        this.data = data;
        this.listener = listener;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public RecyclerViewClickListener getListener() {
        return listener;
    }

    @Override
    public int getType() {
        return MainListAdapter.CLICKED_ITEM;
    }
}
