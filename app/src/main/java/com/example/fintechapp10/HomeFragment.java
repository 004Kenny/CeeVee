package com.example.fintechapp10;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private TextView displayName;
    private TextView displaySlack;
    private TextView displayGithub;
    private TextView displayBiography;
    private MyViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        displayName = rootView.findViewById(R.id.fullName);
        displaySlack = rootView.findViewById(R.id.slack);
        displayGithub = rootView.findViewById(R.id.github);
        displayBiography = rootView.findViewById(R.id.biography);

        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        viewModel.getInputData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String inputData) {
                displayName.setText(inputData);

            }
        });


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("saved_data", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("key_for_data1", "");

        String displayText = name;
        displayName.setText(displayText);


    }
}