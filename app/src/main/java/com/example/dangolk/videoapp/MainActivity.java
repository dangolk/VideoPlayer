package com.example.dangolk.videoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mail);

        playVideoWithMediaController();
//      playYoutubeVideo();


    }

    public void playYoutubeVideo(){
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=Hxy8BZGQ5Jo")));
        Log.i("Video", "Video Playing....");
    }

    public void playVideoWithMediaController(){

        final VideoView videoview = (VideoView) findViewById(R.id.myVideoView);

        MediaController mediaController = new MediaController(this);

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int height = dm.heightPixels;
        int width = dm.widthPixels;

        videoview.setMinimumHeight(height);
        videoview.setMinimumWidth(width);

        videoview.setMediaController(mediaController);

        String localVideo = "/sdcard/vid.mp4";
        String bodyBuilders = "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        String dropBox = "https://www.dropbox.com/s/wn49d8haa9meyu2/vid.mp4";
        videoview.setVideoPath(bodyBuilders);


        videoview.requestFocus();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                videoview.start();
            }
        });
    }
}
