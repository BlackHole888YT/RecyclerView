package com.example.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.databinding.FragmentDetailBinding;

import java.util.ArrayList;


public class DetailFragment extends Fragment {
    private ArrayList<Continents> dataList = new ArrayList<>();
    private ContinentAdapter adapter;
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        loadContinents();
    }

    private void setupRecyclerView() {
        adapter = new ContinentAdapter(dataList, this::handleClick);
        binding.rvV.setAdapter(adapter);
    }

    private void loadContinents() {
        dataList.clear();
        dataList.add(new Continents("Азия"));
        dataList.add(new Continents("Европа"));
        dataList.add(new Continents("Африка"));
        dataList.add(new Continents("Северная Америка"));
        dataList.add(new Continents("Южная Америка"));
        dataList.add(new Continents("Антарктида"));
        dataList.add(new Continents("Австралия"));
        adapter.notifyDataSetChanged();
    }

    private void loadCountries(String continent) {
        dataList.clear();
        switch (continent) {
            case "Азия":
                dataList.add(new Continents("Кыргызстан"));
                dataList.add(new Continents("Китай"));
                dataList.add(new Continents("Индия"));
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private void loadCities(String country) {
        dataList.clear();
        switch (country) {
            case "Кыргызстан":
                dataList.add(new Continents("Бишкек"));
                dataList.add(new Continents("Ош"));
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private void loadCityInfo(String city) {
        dataList.clear();
        switch (city) {
            case "Бишкек":
                dataList.add(new Continents("Бишкек — столица Кыргызстана"));
                break;
            case "Ош":
                dataList.add(new Continents("Ош — второй по величине город Кыргызстана"));
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private void handleClick(Continents item) {
        String name = item.getName();
        if (dataList.size() == 7) {
            loadCountries(name);
        } else if (name.equals("Кыргызстан")) {
            loadCities(name);
        } else {
            loadCityInfo(name);
        }
    }
}
