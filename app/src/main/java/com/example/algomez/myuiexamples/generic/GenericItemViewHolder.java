package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericItemViewHolder<T> extends RecyclerView.ViewHolder {

    public GenericItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);

    public abstract void setListener(RecyclerViewClickListener listener);

}
