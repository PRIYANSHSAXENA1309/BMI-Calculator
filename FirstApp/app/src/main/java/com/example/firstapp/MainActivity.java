package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeight1, edtHeight2;
        Button btnCalc;
        TextView txtResult;
        LinearLayout liMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeight1 = findViewById(R.id.edtHeight1);
        edtHeight2 = findViewById(R.id.edtHeight2);
        btnCalc = findViewById(R.id.btnCalc);
        txtResult = findViewById(R.id.txtResult);
        liMain = findViewById(R.id.liMain);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ht1 = Integer.parseInt(edtHeight1.getText().toString());
                int ht2 = Integer.parseInt(edtHeight2.getText().toString());

                // 1ft=12inch and 1inch=2.54cm
                double ht_m = ((((ht1*12)+ht2)*2.54)/100);
                double bmi = wt/(Math.pow(ht_m,2));
                String res;
                if(bmi>25){
                    res="You are OverWeight,Loose your Weight";
                    liMain.setBackgroundColor(getResources().getColor(R.color.OverWt));
                } else if (bmi<18) {
                    res="You are UnderWeight,Gain your Weight";
                    liMain.setBackgroundColor(getResources().getColor(R.color.UnderWt));
                }
                else {
                    res="You are Healthy,Maintain it";
                    liMain.setBackgroundColor(getResources().getColor(R.color.HealthyWt));
                }
                txtResult.setText(res);

            }
        });

    }
}