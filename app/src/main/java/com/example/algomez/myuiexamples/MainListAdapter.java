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

  private List<ActivityItems> adapterList;
  private RecyclerViewClickListener itemListener;

  public MainListAdapter(List<ActivityItems> adapterList, RecyclerViewClickListener itemListener) {
    this.adapterList = adapterList;
    this.itemListener = itemListener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.items_main, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemName.setText(adapterList.get(position).getName());
    holder.itemDescription.setText(adapterList.get(position).getDescription());
  }

  @Override public int getItemCount() {
    return adapterList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.item_name) TextView itemName;
    @BindView(R.id.item_description) TextView itemDescription;

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
