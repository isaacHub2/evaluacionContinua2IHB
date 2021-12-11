package com.example.ec2isaac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ec2isaac.network.ImageRequester;
import com.example.ec2isaac.network.LocationEntry;

import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<LocationEntry> locationList;
    private ImageRequester imageRequester;

    CardRecyclerViewAdapter(List<LocationEntry> locationList){
        this.locationList = locationList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_card, parent,false);
        return new CardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position){
        if (locationList != null & position < locationList.size()){
            LocationEntry location = locationList.get(position);
            holder.locationTitle.setText(location.title);
            imageRequester.setImageFromUrl(holder.locationImage, location.url);
            holder.locationCountry.setText(location.country);
        }
    }

    @Override
    public int getItemCount(){
        return locationList.size();
    }
}
