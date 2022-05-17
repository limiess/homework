package com.example.homework1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework1.myutil.CountBean;

public class CountVM extends ViewModel {
    /*
    private final MutableLiveData<CountBean> selectC = new MutableLiveData<CountBean>();
    public void setSelectC(CountBean countBean){
        selectC.setValue(countBean);
    }
    public LiveData<CountBean> getSelectC() {
        return selectC;
    }*/
    //用Integer存储数据
    private final MutableLiveData<Integer> selectC = new MutableLiveData<Integer>();

    public void setSelectC(Integer num) {
        selectC.setValue(num);
    }

    public LiveData<Integer> getSelectC() {
        return selectC;
    }
}