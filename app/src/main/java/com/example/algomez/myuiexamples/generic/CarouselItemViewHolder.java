package com.example.algomez.myuiexamples.generic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.algomez.myuiexamples.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CarouselItemViewHolder extends GenericItemViewHolder<ArrayList<GenericItemView>> {

    @BindView(R.id.recycler_view_carrousel)
    RecyclerView recyclerView;

    private AdapterCarousel adapterCarousel;

    public CarouselItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        adapterCarousel = new AdapterCarousel();

        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        itemView.getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false)
        );

        recyclerView.setAdapter(adapterCarousel);
    }

    @Override
    public void bindData(ArrayList<GenericItemView> data) {
        adapterCarousel.addItems(data);
    }

    @Override
    public void setListener(RecyclerViewClickListener listener) {

    }
}
