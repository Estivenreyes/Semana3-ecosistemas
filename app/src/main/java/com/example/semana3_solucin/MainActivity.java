package com.example.semana3_solucin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    Button buttonBlue, buttonWhite, buttonRed;
    String col  = "BLUE";
    ConstraintLayout constraintLayout;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonBlue = findViewById(R.id.buttonBlue);
        buttonWhite = findViewById(R.id.buttonWhite);
        buttonRed = findViewById(R.id.buttonRed);
        constraintLayout = findViewById(R.id.backgroundColor);

        buttonBlue.setOnClickListener(this);
        buttonWhite.setOnClickListener(this);
        buttonRed.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("datos", MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        CambiarFondo();
    }

    public  void  CambiarFondo(){


        Log.e("TAG", "cambio fondo" );

        String color = sharedPreferences.getString("color","f");

        if(color.contentEquals("BLUE")){

            constraintLayout.setBackgroundColor(Color.BLUE);
        }

        if(color.contentEquals("WHITE")){

            constraintLayout.setBackgroundColor(Color.WHITE);
        }

        if(color.contentEquals("RED")){

            constraintLayout.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonBlue:

                sharedPreferences.edit().putString("color","BLUE").apply();
                finish();

                break;
            case R.id.buttonWhite:

                sharedPreferences.edit().putString("color","WHITE").apply();
                finish();

                break;

            case  R.id.buttonRed:

                sharedPreferences.edit().putString("color","RED").apply();
                finish();

                break;

        }


    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        CambiarFondo();

    }

}