package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton playButton,pushButton;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton=findViewById(R.id.playButtoid);
        pushButton=findViewById(R.id.PusshButtoid);

        mediaPlayer=MediaPlayer.create(this,R.raw.song);

        playButton.setOnClickListener(this);
        pushButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.playButtoid)
        {

            if (mediaPlayer!=null)
            {
                mediaPlayer.start();
               int dur= mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this,"song play"+dur,Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId()==R.id.PusshButtoid)
        {

            if (mediaPlayer!=null)
            {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this,"song push",Toast.LENGTH_SHORT).show();
            }
        }

    }

    //app thaka bar howar por jata background a jata song na play hoy
    @Override
    protected void onDestroy() {

        if (mediaPlayer!=null&&mediaPlayer.isPlaying())
        {

            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onDestroy();

    }
}
