package com.example.portfolioapp.team;

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
public class TeamFragment extends Fragment {

    RecyclerView RvTeam;
    TeamAdapter adapter;
    List<TeamItem> items;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvTeam = view.findViewById(R.id.recyclerview_team);

        // create list of team items

        items = new ArrayList<>();
        items.add(new TeamItem("John Doe", getString(R.string.lorem_text2), R.drawable.user_one));
        items.add(new TeamItem("Peter Parker", getString(R.string.lorem_text2), R.drawable.user_two));
        items.add(new TeamItem("Mark Doe", getString(R.string.lorem_text2), R.drawable.user_three));
        items.add(new TeamItem("Jennifer Lopez", getString(R.string.lorem_text2), R.drawable.user_four));
        items.add(new TeamItem("Tony  Ali", getString(R.string.lorem_text2), R.drawable.user_five));
        items.add(new TeamItem("John Doe", getString(R.string.lorem_text2), R.drawable.user_one));
        items.add(new TeamItem("Peter Parker", getString(R.string.lorem_text2), R.drawable.user_two));
        items.add(new TeamItem("Mark Doe", getString(R.string.lorem_text2), R.drawable.user_three));
        items.add(new TeamItem("Jennifer Lopez", getString(R.string.lorem_text2), R.drawable.user_four));
        items.add(new TeamItem("Tony  Ali", getString(R.string.lorem_text2), R.drawable.user_five));

        adapter = new TeamAdapter(items);

        RvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        RvTeam.setAdapter(adapter);

    }
}
