package com.example.c0775696_w2020_mad3125_fp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.c0775696_w2020_mad3125_fp.R;

public class HydroBillFragment extends Fragment {


    public HydroBillFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hydro_bill, container, false);
    }
}
