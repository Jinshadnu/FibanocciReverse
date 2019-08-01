package com.example.fibanoccireverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText_number;
Button button_result;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_number=(EditText)findViewById(R.id.edittext_number);
        button_result=(Button)findViewById(R.id.button);
        button_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number= Integer.parseInt(editText_number.getText().toString());
                fibanocciReverse(number);
                isFibanocci(number);
            }
        });
    }
    //print reverse order
    private void fibanocciReverse(int number) {

        if(isFibanocci(number)==true){
            int a[] = new int[10];
            a[0] = number;
            a[1] = a[1] + number;


            for (int i = 2; i < 10; i++) {
                a[i] = a[i - 2] + a[i - 1];
            }

            for (int i = number - 1; i >= 0; i--) {
                System.out.print(a[i] + " ");
            }
        }

    }

        //check it is fibanocci number

    public  boolean isFibanocci(int number){
        int firstNumber = 0, secondNumber = 1, fibonacciNumber = 0;

        while (fibonacciNumber < number) {
            fibonacciNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fibonacciNumber;
        }
        if (number == fibonacciNumber) {
            Toast.makeText(MainActivity.this,"It is Fibanocci Number",Toast.LENGTH_LONG).show();
            System.out.println("Number belongs to Fibonacci series");
            return true;
        } else {
            Toast.makeText(MainActivity.this,"It is not a fibanocci number",Toast.LENGTH_LONG).show();

            System.out.println("Number does not belong to Fibonacci series");
            return false;
        }

    }


    }



