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
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private TextView displayName;
    private TextView displaySlack;
    private TextView displayGithub;
    private TextView displayBiography;
    private MyViewModel viewModel;
    private Button displayInitials;
    private TextView displayGreetings;

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
        displayInitials = rootView.findViewById(R.id.customButton);
        displayGreetings = rootView.findViewById(R.id.name_of_user);


        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        String fname = sharedPreferences.getString("key_for_data1", "");
        String lname = sharedPreferences.getString("key_for_data2", "");
        String mname = sharedPreferences.getString("key_for_data3", "");
        String slackHandle = sharedPreferences.getString("key_for_data4", "");
        String githubHandle = sharedPreferences.getString("key_for_data5", "");
        String biography = sharedPreferences.getString("key_for_data6", "");
        String initials = sharedPreferences.getString("initials", "");

        String displayText = fname + " " + mname + " " + lname;
        String displayNameText = fname;
        displayName.setText(displayText);
        displaySlack.setText(slackHandle);
        displayGithub.setText(githubHandle);
        displayBiography.setText(biography);
        displayGreetings.setText(displayNameText);


        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        return rootView;
    }

   /* @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getConcatenatedInputData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String concatenatedData) {
                // Update your UI with the concatenated data
                displayName.setText(concatenatedData);
            }
        });

        viewModel.getInputDataFour().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String newData) {
                // Update your UI with the new data for input field 2
                displaySlack.setText(newData);
            }
        });

        viewModel.getInputDataFive().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String newData) {
                // Update your UI with the new data for input field 2
                displayGithub.setText(newData);
            }
        });

        viewModel.getInputDataSix().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String newData) {
                // Update your UI with the new data for input field 2
                displayBiography.setText(newData);
            }
        });
    }*/
}