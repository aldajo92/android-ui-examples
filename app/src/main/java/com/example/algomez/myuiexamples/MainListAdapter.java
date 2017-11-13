package com.example.algomez.myuiexamples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.algomez.myuiexamples.generic.AbstractItemViewHolder;
import com.example.algomez.myuiexamples.generic.CarouselItemViewHolder;
import com.example.algomez.myuiexamples.generic.ClickItemViewHolder;
import com.example.algomez.myuiexamples.generic.GenericItemView;
import com.example.algomez.myuiexamples.generic.GenericItemViewHolder;
import com.example.algomez.myuiexamples.generic.ItemViewHolder;
import com.example.algomez.myuiexamples.generic.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<GenericItemViewHolder> {

    public static final int SINGLE_ITEM = 0;
    public static final int HEADER_ITEM = 1;
    public static final int CARROUSEL_ITEM = 2;
    public static final int CLICKED_ITEM = 3;

    private List<GenericItemView> adapterList;
    private List<GenericItemView> carrouselList;
    private RecyclerViewClickListener itemListener;

    public MainListAdapter(RecyclerViewClickListener itemListener) {
        adapterList = new ArrayList<>();
        carrouselList = new ArrayList<>();
        this.itemListener = itemListener;
    }

    @Override
    public GenericItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        GenericItemViewHolder viewHolder;
        switch (viewType){
            case SINGLE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_main, parent, false);
                viewHolder = new ItemViewHolder(view);
                break;
            case HEADER_ITEM:
                view = new TextView(parent.getContext());
                viewHolder = new AbstractItemViewHolder<String, TextView>((TextView) view) {
                    @Override
                    public void customBindData(String data, TextView itemView) {
                        itemView.setText(data);
                    }
                };
                break;
            case CARROUSEL_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrousel, parent, false);
                viewHolder = new CarouselItemViewHolder(view);
                break;
            case CLICKED_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_main, parent, false);
                viewHolder = new ClickItemViewHolder(view);
                break;
            default:
                view = new TextView(parent.getContext());
                viewHolder = new AbstractItemViewHolder<String, TextView>((TextView) view) {
                    @Override
                    public void customBindData(String data, TextView itemView) {
                        itemView.setText(data);
                    }
                };
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GenericItemViewHolder holder, int position) {
        holder.bindData(adapterList.get(position).getData());
        holder.setListener(adapterList.get(position).getListener());
    }

    @Override
    public int getItemViewType(int position) {
        return adapterList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    public void addItem(GenericItemView item){
        adapterList.add(item);
        notifyDataSetChanged();
    }

    public void addItemCarrousel(GenericItemView itemView) {
        carrouselList.add(itemView);
        notifyDataSetChanged();
    }
}
