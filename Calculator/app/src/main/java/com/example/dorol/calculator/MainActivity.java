package com.example.dorol.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);

        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button multiButton = findViewById(R.id.multiButton);
        Button divideButton = findViewById(R.id.divideButton);

        Button buttonClear = findViewById(R.id.buttonClear);

        Button okButton = findViewById(R.id.okButton);
        final EditText editText = findViewById(R.id.editText);

        final ArrayList<Integer> calList = new ArrayList<>();

        button0.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 0);
                calList.add(0);
            }
        });

        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 1);
                calList.add(1);
            }
        });

        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
                calList.add(2);
            }
        });

        button3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 3);
                calList.add(3);
            }
        });

        button4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 4);
                calList.add(4);
            }
        });

        button5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 5);
                calList.add(5);
            }
        });

        button6.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 6);
                calList.add(6);
            }
        });

        button7.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 7);
                calList.add(7);
            }
        });

        button8.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 8);
                calList.add(8);
            }
        });

        button9.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 9);
                calList.add(9);
            }
        });

        buttonClear.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText("");
                calList.clear();
            }
        });


        plusButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
                calList.add(-1);
            }
        });
        minusButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
                calList.add(-2);
            }
        });
        multiButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
                calList.add(-2);
            }
        });
        divideButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
            }
        });

        okButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String editTextSttring = editText.getText().toString();
                editText.setText(editTextSttring + 2);
            }
        });

    }
}
