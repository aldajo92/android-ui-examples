package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.algomez.myuiexamples.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterCarousel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GenericItemView> listCarrousel;

    public AdapterCarousel() {
        listCarrousel = new ArrayList<>();
    }

    public void addItem(GenericItemView item){
        listCarrousel.add(item);
    }

    public void addItems(List<GenericItemView> items) {
        listCarrousel.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrousel_view, parent, false);
        return new ItemCarrousel(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemCarrousel) holder).itemText.setText((String) listCarrousel.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return listCarrousel.size();
    }

    public class ItemCarrousel extends RecyclerView.ViewHolder{
        @BindView(R.id.text_view_item)
        TextView itemText;

        public ItemCarrousel(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
