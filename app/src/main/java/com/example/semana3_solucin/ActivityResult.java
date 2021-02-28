package com.example.semana3_solucin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ActivityResult extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    TextView nombreFinal,nota;
    ConstraintLayout cl;
    Button calcular;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nombreFinal = findViewById(R.id.nombrefinal);
        nota = findViewById(R.id.calificacion);
        cl= findViewById(R.id.layoutResult);
        calcular=findViewById(R.id.buttonCalcularOtra);

        sharedPreferences= getSharedPreferences("datos",MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        String nombre = sharedPreferences.getString("nombre","paila");
        String calificacion = sharedPreferences.getString("nota","paila");
        sharedPreferences.getString("color","f");
        calcular.setOnClickListener(this);
        nombreFinal.setText("Hola "+nombre+" tu nota final es:");
        nota.setText(calificacion);
        CambiarFondo();
    }

    public  void  CambiarFondo(){


        Log.e("TAG", "cambio fondo" );

        String color =sharedPreferences.getString("color","f");

        if(color.contentEquals("BLUE")){

            cl.setBackgroundColor(Color.BLUE);
        }

        if(color.contentEquals("WHITE")){

            cl.setBackgroundColor(Color.WHITE);
        }

        if(color.contentEquals("RED")){

            cl.setBackgroundColor(Color.RED);
        }

    }


    @Override
    public void onClick(View v) {

        Intent intent= new Intent(this,ActivityName.class);
        startActivity(intent);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        CambiarFondo();

    }

}
