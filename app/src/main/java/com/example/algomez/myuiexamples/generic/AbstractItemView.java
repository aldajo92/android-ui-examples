package com.example.algomez.myuiexamples.generic;

public class AbstractItemView<T> implements GenericItemView<T> {

    private T data;
    private int type;

    public AbstractItemView(T data, int type) {
        this.data = data;
        this.type = type;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public RecyclerViewClickListener getListener() {
        return null;
    }

    @Override
    public int getType() {
        return type;
    }
}
