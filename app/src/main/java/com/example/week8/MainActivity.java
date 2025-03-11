package com.example.week8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputFirst, inputSecond;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirst = findViewById(R.id.inputFirstNumber);
        inputSecond = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);


        findViewById(R.id.buttonPlus).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.buttonMinus).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> calculate('×'));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> calculate('÷'));
    }

    private void calculate(char operator) {
        double num1 = parseDouble(inputFirst.getText().toString());
        double num2 = parseDouble(inputSecond.getText().toString());
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '×': result = num1 * num2; break;
            case '÷': result = num2 != 0 ? num1 / num2 : 0; break;
        }

        textResult.setText("Outcome:" + result);
    }

    private double parseDouble(String str) {
        return str.isEmpty() ? 0 : Double.parseDouble(str);
    }
}