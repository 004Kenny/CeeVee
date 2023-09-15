package com.example.fintechapp10;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<String> inputData = new MutableLiveData<>();
    private final MutableLiveData<String> inputDataTwo = new MutableLiveData<>();
    private final MutableLiveData<String> inputDataThree = new MutableLiveData<>();
    private final MutableLiveData<String> inputDataFour = new MutableLiveData<>();
    private final MutableLiveData<String> inputDataFive = new MutableLiveData<>();
    private final MutableLiveData<String> inputDataSix = new MutableLiveData<>();


    public void setInputData(String text) {
        inputData.setValue(text);
    }
    public void setInputDataTwo(String text) {
        inputData.setValue(text);
    }
    public void setInputDataThree(String text) {
        inputData.setValue(text);
    }
    public void setInputDataFour(String text) {
        inputData.setValue(text);
    }
    public void setInputDataFive(String text) {
        inputData.setValue(text);
    }
    public void setInputDataSix(String text) {
        inputData.setValue(text);
    }

    public LiveData<String> getInputData() {
        return inputData;
    }
    public LiveData<String> getInputDataTwo() {
        return inputDataTwo;
    }
    public LiveData<String> getInputDataThree() {
        return inputDataThree;
    }
    public LiveData<String> getInputDataFour() {
        return inputDataFour;
    }
    public LiveData<String> getInputDataFive() {
        return inputDataFive;
    }
    public LiveData<String> getInputDataSix() {
        return inputDataSix;
    }

    public LiveData<String> getConcatenatedInputData() {
        // Concatenate inputData1, inputData2, and inputData3
        String concatenatedData = inputData.getValue() + " " + inputDataThree.getValue() + " " + inputDataTwo.getValue();
        MutableLiveData<String> concatenatedLiveData = new MutableLiveData<>();
        concatenatedLiveData.setValue(concatenatedData);
        return concatenatedLiveData;
    }


}
