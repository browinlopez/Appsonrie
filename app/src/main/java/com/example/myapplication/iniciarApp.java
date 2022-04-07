package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class iniciarApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_app);
    }

    //metodo siguiente boton Salir
    public void Salir(View view) {
        Intent Salir = new Intent(this,  MainActivity.class);
        startActivity(Salir);
    }
    //metodo ir Fonoaudiologia
    public void Fonoaudiologia(View view) {
        Intent Fonoaudiologia = new Intent(this, fonoaudiologia.class);
        startActivity(Fonoaudiologia);
    }
    //metodo ir odontologia
    public void Odontologia(View view) {
        Intent Odontologia = new Intent(this, Odontologia.class);
        startActivity(Odontologia);
    }
    //metodo ir Psicologia
    public void Psicologia(View view) {
        Intent Psicologia = new Intent(this, Psicologia.class);
        startActivity(Psicologia);
    }
}