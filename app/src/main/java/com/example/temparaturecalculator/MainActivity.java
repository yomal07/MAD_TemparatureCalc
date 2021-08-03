package com.example.temparaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_val;
    RadioButton btn_celc;
    RadioButton btn_fahren;
    Button btn_calc;
    TextView display_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_val = findViewById(R.id.editText);
        btn_celc = findViewById(R.id.btn_celcius);
        btn_fahren = findViewById(R.id.btn_fahrenhite);
        btn_calc = findViewById(R.id.btn_calc);
        display_text = findViewById(R.id.txt_display);
    }

    @Override
    //clicking the button to calculate the answer
    protected void onResume() {
        super.onResume();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    //calculation of the temparature
    private void calculateAnswer() {
        //create an object using Calculations class
        Calculation calc = new Calculation();

        //decleration of a variable to store the value in edit text
        String temparature = et_val.getText().toString();

        //condition for not entering any inputs
        if(TextUtils.isEmpty(temparature)){
            //method to add the toast messages
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
            temparature = "0.0";
            display_text.setText(temparature);
        }

        //condition after entering the values
        else{
            try {
                    //Converting the string value into a Float
                    Float temFloat = Float.parseFloat(temparature);
                    if (btn_celc.isChecked()) {
                        // convert it into Fahrenheit and display the answer
                        Float ans = calc.convertFahrenheitToCelcius(temFloat);
                        display_text.setText(new Float(ans).toString());

                    } else if (btn_fahren.isChecked()) {
                        // convert it into Celcius and display the answer
                        Float ans = calc.convertCelciusToFahrenheit(temFloat);
                        display_text.setText(new Float(ans).toString());
                    } else {
                        //if no button is pressed
                        Toast.makeText(this, "Please Select a Radio!", Toast.LENGTH_LONG).show();
                        temFloat = 0.0f;
                        //converting the Float to a String
                        display_text.setText(new Float(temFloat).toString());
                    }

                }catch (NullPointerException e){}
                }
            }
        }