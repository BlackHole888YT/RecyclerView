package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContinentViewHolder extends RecyclerView.ViewHolder {
    private TextView contView;

    public ContinentViewHolder(@NonNull View itemView) {
        super(itemView);
        contView = itemView.findViewById(R.id.continent_name);
    }

    public void bind(Continents continents) {
        contView.setText(continents.getName());
    }
}

