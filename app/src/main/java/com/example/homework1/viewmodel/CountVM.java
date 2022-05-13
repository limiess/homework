package com.example.homework1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework1.myutil.CountUtil;

public class CountVM extends ViewModel {
    private final MutableLiveData<CountUtil> selectMusic = new MutableLiveData<CountUtil>();

    public void setSelectMusic(CountUtil countUtil){
        selectMusic.setValue(countUtil);
    }

    public LiveData<CountUtil> getSelectMusic() {
        return selectMusic;
    }

}
