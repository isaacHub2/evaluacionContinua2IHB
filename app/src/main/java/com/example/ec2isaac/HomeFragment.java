package com.example.ec2isaac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ec2isaac.network.LocationEntry;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void setUpToolBar(View view){
        Toolbar toolbar = view.findViewById(R.id.app_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        if (activity != null){
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        setUpToolBar(view);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        CardRecyclerViewAdapter adapter = new CardRecyclerViewAdapter(LocationEntry.initLocationEntryList(getResources()));

        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.location_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.location_grid_spacing_small);
        recyclerView.addItemDecoration(new LocationGridItemDecoration(largePadding, smallPadding));

        return view;
    }
}
