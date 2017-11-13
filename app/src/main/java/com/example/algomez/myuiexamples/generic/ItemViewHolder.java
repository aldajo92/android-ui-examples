package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.algomez.myuiexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_view_name)
    public TextView itemTitle;

    private RecyclerViewClickListener listener;

    public ItemViewHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
//        this.listener = listener;
    }

    @OnClick(R.id.card_view)
    public void onClick(){
        if(listener != null)
        listener.itemClicked();
    }
}