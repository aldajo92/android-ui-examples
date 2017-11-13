package com.example.algomez.myuiexamples.generic;

import android.view.View;

public abstract class AbstractItemViewHolder<T, S extends View> extends GenericItemViewHolder<T> {

    private T data;
    private S itemView;

    public AbstractItemViewHolder(S itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    @Override
    public void bindData(T data) {
        this.data = data;
        customBindData(data, itemView);
    }

    @Override
    public void setListener(RecyclerViewClickListener listener) {

    }

    public abstract void customBindData(T data, S itemView);
}
