package com.example.homework1.viewmodel;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.when;

//import org.gradle.process.internal.worker.*;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.homework1.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({CountVM.class})
public class CountVMTest {

    /*@Test
    public void setSelectCTest() throws Exception {
        CountVM countVM = PowerMockito.mock(CountVM.class);
        doNothing().when(countVM).setSelectC(anyInt());
    }*/

    @Test
    public void getSelectCTest() throws Exception {
        int expected = 10;
        CountVM countVM=new CountVM();
        //CountVM countVM = PowerMockito.mock(CountVM.class);
        //when(countVM,"getSelectC").thenReturn(expected);
        //LiveData<Integer> liveData = Whitebox.invokeMethod(countVM, "getSelectC");
        int actual=countVM.getSelectC().getValue();
        assertEquals(expected, actual);
    }
}