package com.cyt.todayinformation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.vv_play)
    FullScreenVideoView vvPlay;
    @BindView(R.id.tv_splash_timer)
    TextView tvSplashTimer;


    private SplashTimerPresenter timerPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);

        initTimerPresenter();
        initListener();
        initVideo();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }


    private void initVideo() {
        vvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    private void initListener() {

        vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        tvSplashTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerPresenter.cancel();
    }

    public void setTvTimer(String s) {
        tvSplashTimer.setText(s);
    }
}
