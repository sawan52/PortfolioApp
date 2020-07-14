package com.example.portfolioapp.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.portfolioapp.R;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder> {

    List<PortfolioItem> mData;
    PortfolioCallback listener;

    public PortfolioAdapter(List<PortfolioItem> mData, PortfolioCallback listener) {
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PortfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfolio, parent, false);
        return new PortfolioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(mData.get(position).getImage()).into(holder.tvImage);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PortfolioViewHolder extends RecyclerView.ViewHolder {

        ImageView tvImage;

        public PortfolioViewHolder(@NonNull View itemView) {
            super(itemView);

            tvImage = itemView.findViewById(R.id.item_portfolio_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPortfolioItemClick(getAdapterPosition());
                }
            });

        }
    }
}
