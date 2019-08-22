package com.cyt.todayinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView mVideoView;

    private TextView mTvTimer;

    private CustomCountDownTimer mCustomCountDownTimer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        mTvTimer = findViewById(R.id.tv_splash_timer);
        mVideoView = findViewById(R.id.vv_play);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });

        mCustomCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳过");
            }
        });

        mCustomCountDownTimer.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCustomCountDownTimer.cancel();
    }
}
