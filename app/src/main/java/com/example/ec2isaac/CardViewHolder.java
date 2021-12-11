package com.example.ec2isaac;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView locationImage;
    public TextView locationTitle;
    public TextView locationCountry;

    public CardViewHolder(@NonNull View itemView){
        super(itemView);

        locationImage = itemView.findViewById(R.id.location_image);
        locationTitle = itemView.findViewById(R.id.location_title);
        locationCountry = itemView.findViewById(R.id.location_country);
    }
}
