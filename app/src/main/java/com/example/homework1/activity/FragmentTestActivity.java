package com.example.homework1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homework1.R;
import com.example.homework1.fragment.AddFragment;
import com.example.homework1.fragment.DisplayFragment;
import com.example.homework1.viewmodel.CountVM;

public class FragmentTestActivity extends AppCompatActivity {
    private CountVM countVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        //addbutton,即tab1
        Button button1=(Button) findViewById(R.id.tab1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AddFragment());
            }
        });

        //showbutton,即tab2
        Button button2=(Button) findViewById(R.id.tab2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DisplayFragment());
            }
        });

        //动态更换fragment,默认为addfragment
        replaceFragment(new AddFragment());
    }
    private void replaceFragment(Fragment fragment){
        //得到一个FragmentManager
        FragmentManager fragmentManager=getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //向容器中替换碎片
        fragmentTransaction.replace(R.id.fbottom,fragment);
        //提交事务
        fragmentTransaction.commit();
    }



}