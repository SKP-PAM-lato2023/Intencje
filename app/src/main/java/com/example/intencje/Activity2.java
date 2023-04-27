package com.example.intencje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            double liczba = bundle.getDouble("Wartosc1");
            String napis = bundle.getString("Wartosc2");

            Toast.makeText(this, liczba+" "+napis, Toast.LENGTH_SHORT).show();
        }
    }
}