package com.example.homework1.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homework1.R;
import com.example.homework1.myutil.CountBean;
import com.example.homework1.viewmodel.CountVM;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  Integer te=0;
    private CountVM countVM;
    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add, container, false);
        countVM=new ViewModelProvider(
                requireActivity(),
                new ViewModelProvider.NewInstanceFactory()).get(CountVM.class);

        //设置按钮样式与点击事件
        Button button =(Button) view.findViewById(R.id.add);
        Drawable drawable=(Drawable) getResources().getDrawable(R.drawable.add_button_background);
        drawable.setBounds(0,0,380,380);
        button.setCompoundDrawables(drawable,null,null,null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountBean.setNum(CountBean.getNum()+1);
                countVM.setSelectC(++te);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}