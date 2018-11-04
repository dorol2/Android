package com.example.dorol.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // View를 return 하지 않으면 fragment는 view를 가지지 않는다.
        //Fragment가 UI를 처음으로 그리고자할 때에 호출

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        textView = view.findViewById(R.id.fragment_b_textView); //textView 가져오기
        textView.setText(getClass().getSimpleName()); // textView에 setText

        return view;
    }
}
