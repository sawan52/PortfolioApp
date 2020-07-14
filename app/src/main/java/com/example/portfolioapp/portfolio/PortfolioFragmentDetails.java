package com.example.portfolioapp.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.portfolioapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragmentDetails extends BottomSheetDialogFragment {

    private ImageView img;
    private TextView title, description;

    public PortfolioFragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img = view.findViewById(R.id.portfolio_details_img);
        title = view.findViewById(R.id.portfolio_details_title);
        description = view.findViewById(R.id.portfolio_details_desc);

        // first we need to get our portfolio object from the bundle we have sent.

        Bundle bundle = getArguments();
        PortfolioItem item = (PortfolioItem) Objects.requireNonNull(bundle).getSerializable("object");

        // now we have the item and we need to just load it.

        loadPortfolioData(Objects.requireNonNull(item));

    }

    void loadPortfolioData(PortfolioItem item) {

        Glide.with(Objects.requireNonNull(getContext())).load(item.getImage()).into(img);
        // bind title and description....

    }

}
