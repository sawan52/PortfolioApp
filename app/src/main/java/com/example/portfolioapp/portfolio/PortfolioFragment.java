package com.example.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portfolioapp.R;
import com.example.portfolioapp.cv.CVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment {

    List<PortfolioItem> items;
    RecyclerView RvP;
    PortfolioAdapter adapter;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvP = view.findViewById(R.id.recyclerview_portfolio);

        // create list of portfolio items

        items = new ArrayList<>();
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());
        items.add(new PortfolioItem());

        adapter = new PortfolioAdapter(items);

        // setup Grid recycler View

        RvP.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        RvP.setAdapter(adapter);

    }
}
