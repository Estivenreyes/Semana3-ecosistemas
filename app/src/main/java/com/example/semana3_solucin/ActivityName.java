package com.example.semana3_solucin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ActivityName extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    Button config, continua;
    EditText nameEdit;
    ConstraintLayout constraintLayout;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        config=findViewById(R.id.config);
        continua = findViewById(R.id.continua);
        nameEdit= findViewById(R.id.nameEdit);
        constraintLayout= findViewById(R.id.layoutName);
        sharedPreferences= getSharedPreferences("datos", MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        config.setOnClickListener(this);
        continua.setOnClickListener(this);
        //constraintLayout.setBackgroundColor(Color.BLACK);
        CambiarFondo();

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            //Boton configurar
            case R.id.config:

                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

                break;

            case R.id.continua:

                if(nameEdit.getText().toString().isEmpty()){

                    Toast.makeText((this), "por favor ingreas un nombre", Toast.LENGTH_SHORT).show();

                }

                else {
                    String name;
                    name = nameEdit.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("datos", MODE_PRIVATE);
                    sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                    sharedPreferences.edit().putString("nombre", name).apply();

                    Intent i = new Intent(this, ActivityNota.class);
                    startActivity(i);
                }
                break;

        }

    }

    public  void  CambiarFondo(){



        String color =sharedPreferences.getString("color","f");


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

}
