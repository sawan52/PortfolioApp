package com.example.portfolioapp.cv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;

import java.util.List;

public class CVAdapter extends RecyclerView.Adapter<CVAdapter.CVViewHolder> {

    List<CVItem> mData;

    public CVAdapter(List<CVItem> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public CVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv, parent, false);
        return new CVViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CVViewHolder holder, int position) {

        holder.tvTitle.setText(mData.get(position).getTitle());
        holder.tvDescription.setText(mData.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CVViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvDescription;

        public CVViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.item_cv_title);
            tvDescription = itemView.findViewById(R.id.item_cv_desc);

        }
    }
}
