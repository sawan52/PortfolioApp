package com.example.portfolioapp.cv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CVFragment extends Fragment {

    RecyclerView RvCv;
    CVAdapter adapter;
    List<CVItem> items;

    public CVFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvCv = view.findViewById(R.id.recyclerview_cv);

        // create a list of CV Items

        items = new ArrayList<>();
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text)));
        items.add(new CVItem("28 April 2015", getString(R.string.lorem_text2)));
        items.add(new CVItem("02 September 2016", getString(R.string.lorem_text)));
        items.add(new CVItem("13 January 2018", getString(R.string.lorem_text2)));
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text)));
        items.add(new CVItem("28 April 2015", getString(R.string.lorem_text2)));
        items.add(new CVItem("02 September 2016", getString(R.string.lorem_text)));
        items.add(new CVItem("13 January 2018", getString(R.string.lorem_text2)));
        items.add(new CVItem("13 January 2018", getString(R.string.lorem_text)));
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text2)));

        adapter = new CVAdapter(items);

        RvCv.setLayoutManager(new LinearLayoutManager(getContext()));
        RvCv.setAdapter(adapter);

    }

}
