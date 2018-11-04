package com.example.dorol.fragmenttest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button01;
    Button button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null)
                return;

            FragmentA firstFragment = new FragmentA();

            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            //

            button01 = findViewById(R.id.button01);
            button02 = findViewById(R.id.button02);

            button01.setText("FragmentA");
            button02.setText("FragmentB");

            button01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectFragment(v);
                }
            });

            button02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectFragment(v);
                }
            });
        }
    }

    public void SelectFragment(View view) {
        Fragment fragment = null;

        switch(view.getId()) {
            case R.id.button01:
                fragment = new FragmentA();
                break;
            case R.id.button02:
                fragment = new FragmentB();
                break;
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//Fragment의 추가, 제거, 변경 등의 작업 가능
        fragmentTransaction.replace(R.id.fragment_container, fragment); // fragment 변경
        fragmentTransaction.addToBackStack(null); //백스택에 저장 : 뒤로가기를 했을 때 이전 fragment로 이동
        fragmentTransaction.commit(); // 적용
    }
}

