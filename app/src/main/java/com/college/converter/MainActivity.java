package com.college.converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.college.converter.databinding.ActivityMainBinding;

/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;


    static private final Float CONVERSION_RATE = 0.80F;
    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Activity started.");
        

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        Button buttonConvert = variableBinding.convertButton;


        buttonConvert.setOnClickListener( view ->  {
            convertCurrency(view);
        } );
        Log.i(TAG, "onCreate: Activity  ready for user interaction.");

    }

    public void convertCurrency(View view) {
        Log.i(TAG, "convertCurrency: Starting currency conversion process.");

        EditText inputView = variableBinding.entryId;

        String inputAmount = inputView.getText().toString();

        TextView resultView = variableBinding.resultId;

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);

            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            //resultView.setText(resultFloat + "Euros ";
            resultView.setText( resultFloat + getString(R.string.euros_result) );
        }
        Log.i(TAG, "convertCurrency: Currency conversion process completed.");
    }


}