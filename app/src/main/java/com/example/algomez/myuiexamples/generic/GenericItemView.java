package com.example.algomez.myuiexamples.generic;

public interface GenericItemView<T> {
    T getData();

    RecyclerViewClickListener getListener();

    int getType();
}
