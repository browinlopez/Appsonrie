package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Odontologia extends AppCompatActivity {


    VideoView videoView;
    MediaPlayer mp;
    Button vocales;

    TextView PauseResumeTextView;
    public int PauseResumeFlag=0, PausedLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odontologia);



        videoView = (VideoView) findViewById(R.id.video);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);


        videoView.start();


        vocales = (Button) findViewById(R.id.Vocales);
        mp = MediaPlayer.create(this, R.raw.vocales);
        vocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

    }
    public void pause (View v){

        if(mp.isPlaying()){
            mp.pause();
        }

    }



    //metodo siguiente boton Regresar
    public void RegresarInicioApp(View view) {
        Intent RegresarInicioApp = new Intent(this, iniciarApp.class);
        startActivity(RegresarInicioApp);
    }
}