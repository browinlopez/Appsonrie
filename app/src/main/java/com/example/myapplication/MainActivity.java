package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.carrusel1, R.drawable.carrusel2, R.drawable.carrusel3};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image: images){
            flipperImages(image);
        }

    }
    public void flipperImages(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);


        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);

    }


    //metodo siguiente boton irRegistro
    public void irRegistro(View view) {
        Intent irRegistro = new Intent(this, Registro.class);
        startActivity(irRegistro);
    }

    //metodo siguiente boton irLogin

    public void irLogin(View view) {
        Intent irLogin = new Intent(this, iniciar.class);
        startActivity(irLogin);
}
}