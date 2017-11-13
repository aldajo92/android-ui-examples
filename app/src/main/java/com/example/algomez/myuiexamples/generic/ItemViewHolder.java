package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.algomez.myuiexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemViewHolder extends GenericItemViewHolder<String> {

    @BindView(R.id.text_view_name)
    TextView itemTitle;

    private RecyclerViewClickListener listener;

    public ItemViewHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(String data) {
        itemTitle.setText(data);
    }

    @Override
    public void setListener(RecyclerViewClickListener listener) {
        this.listener = listener;
    }

    @OnClick(R.id.card_view)
    void onClick(){
        if(listener != null)
        listener.itemClicked();
    }
}