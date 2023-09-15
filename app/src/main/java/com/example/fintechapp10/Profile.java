package com.example.fintechapp10;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Closeable;


public class Profile extends Fragment {

    private Button saveBtn;
    private Button userInitials;
    private EditText edtFirstName;
    private  EditText edtLastName;
    private EditText edtMiddleNam;
    private EditText slack;
    private EditText github;
    private EditText bio;
    private MyViewModel model;



    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        saveBtn = rootView.findViewById(R.id.btnSaveUserInfo);
        userInitials = rootView.findViewById(R.id.profileInitials);

        edtFirstName = rootView.findViewById(R.id.edtFirstName);
        String firstName = sharedPreferences.getString("key_for_data1", "");
        edtFirstName.setText(firstName);

        edtLastName = rootView.findViewById(R.id.edtLastName);
        String lastName = sharedPreferences.getString("key_for_data2", "");
        edtLastName.setText(lastName);

        edtMiddleNam = rootView.findViewById(R.id.edtMiddleName);
        String middleName = sharedPreferences.getString("key_for_data3", "");
        edtMiddleNam.setText(middleName);

        slack = rootView.findViewById(R.id.edtEmail);
        String slackHandle = sharedPreferences.getString("key_for_data4", "");
        slack.setText(slackHandle);

        github = rootView.findViewById(R.id.edtGtHandle);
        String githubHandle = sharedPreferences.getString("key_for_data5", "");
        github.setText(githubHandle);

        bio = rootView.findViewById(R.id.edtBiography);
       String biography = sharedPreferences.getString("key_for_data6", "");
        bio.setText(biography);

        model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputData = edtFirstName.getText().toString();
                String inputDataTwo = edtLastName.getText().toString();
                String inputDataThree = edtMiddleNam.getText().toString();
                String inputDataFour = slack.getText().toString();
                String inputDataFive = github.getText().toString();
                String inputDataSix = bio.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("key_for_data1", inputData);
                editor.putString("key_for_data2", inputDataTwo);
                editor.putString("key_for_data3", inputDataThree);
                editor.putString("key_for_data4", inputDataFour);
                editor.putString("key_for_data5", inputDataFive);
                editor.putString("key_for_data6", inputDataSix);
                editor.apply();

                updateInitials();

                Toast.makeText(requireContext(), "Data saved!", Toast.LENGTH_SHORT).show();


                model.setInputData(inputData);
                model.setInputData(inputDataTwo);
                model.setInputData(inputDataThree);
                model.setInputData(inputDataFour);
                model.setInputData(inputDataFive);
                model.setInputData(inputDataSix);
            }
        });

        // Inflate the layout for this fragment
       return rootView;
    }

    public void updateInitials(){
        String fName = edtFirstName.getText().toString();
        String lName = edtLastName.getText().toString();

        char firstInitial = fName.charAt(0);
        char lastInitial = lName.charAt(0);


        String firstInitialString = String.valueOf(firstInitial);
        String lastInitialString = String.valueOf(lastInitial);

        if (userInitials != null){
            userInitials.setText(firstInitialString + lastInitialString);
        }
    }
}