package com.example.algomez.myuiexamples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

/**
 * Created by algomez on 1/8/17.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

  private List<String> adapterList;
  private RecyclerViewClickListener itemListener;

  public MainListAdapter(List<String> adapterList, RecyclerViewClickListener itemListener) {
    this.adapterList = adapterList;
    this.itemListener = itemListener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.items_main, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemTitle.setText(adapterList.get(position));
  }

  @Override public int getItemCount() {
    return adapterList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.pokemon_name) TextView itemTitle;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      itemListener.recyclerViewListClicked(v, this.getAdapterPosition());
    }
  }

  interface RecyclerViewClickListener {
    void recyclerViewListClicked(View v, int position);
  }
}
