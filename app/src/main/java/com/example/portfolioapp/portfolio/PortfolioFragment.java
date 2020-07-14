package com.example.portfolioapp.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

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

        items.add(new PortfolioItem(R.drawable.project_one));
        items.add(new PortfolioItem(R.drawable.project_two));
        items.add(new PortfolioItem(R.drawable.project_three));
        items.add(new PortfolioItem(R.drawable.project_four));
        items.add(new PortfolioItem(R.drawable.project_one));
        items.add(new PortfolioItem(R.drawable.project_two));
        items.add(new PortfolioItem(R.drawable.project_three));
        items.add(new PortfolioItem(R.drawable.project_four));
        items.add(new PortfolioItem(R.drawable.project_one));

        adapter = new PortfolioAdapter(items, this);

        // setup Grid recycler View

        RvP.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        RvP.setAdapter(adapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {

        // handle click listener event when portfolio item clicked

        // first we need to create a fragment bottom sheet instance

        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();

        // now we need to send portfolio item to portfolio dialog fragment
        // we will use bundle for that
        // also we need our portfolio item data class to implement serializable interface so that we can send it.

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", items.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        // now lets open the portfolio bottom sheet fragment

        portfolioFragmentDetails.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "tagname");


    }
}
