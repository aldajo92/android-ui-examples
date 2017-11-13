package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.algomez.myuiexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickItemViewHolder extends GenericItemViewHolder<String> {

    @BindView(R.id.text_view_name)
    public TextView itemTitle;

    private RecyclerViewClickListener listener;

    public ClickItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
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
    public void onClick(){
        if(listener != null)
            listener.itemClicked();
    }
}
