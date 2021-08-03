package com.example.temparaturecalculator;

public class Calculation {

    //Celcius convertion
    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }

    //Fahrenhite convertion
    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }

}
