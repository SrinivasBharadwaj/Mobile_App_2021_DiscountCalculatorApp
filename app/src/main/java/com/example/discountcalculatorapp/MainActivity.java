/*
 * Srinivas Bharadwaj Chintalapati
 */
package com.example.discountcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalculate;
        EditText editTextInputPrice;
        TextView finalResult;
        RadioGroup radioGrp;
        radioGrp = findViewById(R.id.radioGroup);

        finalResult = findViewById(R.id.textViewResult);
        editTextInputPrice = findViewById(R.id.editTextInputPrice);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double price = Double.parseDouble(editTextInputPrice.getText().toString());
                    double result = 0.00;
                    if(radioGrp.getCheckedRadioButtonId() == R.id.radioButton5Percent) {
                        result = price - price * 0.05;
                    } else if(radioGrp.getCheckedRadioButtonId() == R.id.radioButton10Percent) {
                        result = price - price * 0.1;
                    } else if(radioGrp.getCheckedRadioButtonId() == R.id.radioButton15Percent) {
                        result = price - price * 0.15;
                    } else if(radioGrp.getCheckedRadioButtonId() == R.id.radioButton20Percent) {
                        result = price - price * 0.2;
                    } else if(radioGrp.getCheckedRadioButtonId() == R.id.radioButton50Percent) {
                        result = price - price * 0.5;
                    }

                    Log.d("FINAL RESULT", " " + result);
                    finalResult.setText("" + result);
                    
                }catch(NumberFormatException numex) {
                    Toast.makeText(buttonCalculate.getContext(), "Please enter valid number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button buttonClearLabel;
        buttonClearLabel = findViewById(R.id.buttonClear);

        buttonClearLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextInputPrice.setText(" ");
                finalResult.setText(" ");
                RadioButton radioBtn5;
                radioBtn5 = findViewById(R.id.radioButton5Percent);
                radioBtn5.setChecked(true);
            }
        });
    }

}