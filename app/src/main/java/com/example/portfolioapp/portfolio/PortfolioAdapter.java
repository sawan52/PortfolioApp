package com.example.portfolioapp.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder> {

    List<PortfolioItem> mData;

    public PortfolioAdapter(List<PortfolioItem> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public PortfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfolio, parent, false);
        return new PortfolioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHolder holder, int position) {

        holder.tvPosition.setText(String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class PortfolioViewHolder extends RecyclerView.ViewHolder{

        TextView tvPosition;

        public PortfolioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.item_portfolio_text);
        }
    }
}
