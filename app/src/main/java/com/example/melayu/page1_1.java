package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class page1_1 extends AppCompatActivity {
    MediaPlayer mySong1, mySong2, mySong3, mySong4, mySong5, mySong6, mySong7, mySong8, mySong9, mySong10, mySong11, mySong12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_1);
        mySong1 = MediaPlayer.create(page1_1.this, R.raw.sen1);
        mySong2 = MediaPlayer.create(page1_1.this, R.raw.sen2);
        mySong3 = MediaPlayer.create(page1_1.this, R.raw.sen3);
        mySong4 = MediaPlayer.create(page1_1.this, R.raw.sen4);
        mySong5 = MediaPlayer.create(page1_1.this, R.raw.sen5);
        mySong6 = MediaPlayer.create(page1_1.this, R.raw.sen6);
        mySong7 = MediaPlayer.create(page1_1.this, R.raw.sen7);
        mySong8 = MediaPlayer.create(page1_1.this, R.raw.sen8);
        mySong9 = MediaPlayer.create(page1_1.this, R.raw.sen9);
        mySong10 = MediaPlayer.create(page1_1.this, R.raw.sen10);
        mySong11 = MediaPlayer.create(page1_1.this, R.raw.sen11);
        mySong12 = MediaPlayer.create(page1_1.this, R.raw.sen12);

    }

    public void playIT1(View v) { mySong1.start(); }
    public void playIT2(View v) { mySong2.start(); }
    public void playIT3(View v) { mySong3.start(); }
    public void playIT4(View v) { mySong4.start(); }
    public void playIT5(View v) { mySong5.start(); }
    public void playIT6(View v) { mySong6.start(); }
    public void playIT7(View v) { mySong7.start(); }
    public void playIT8(View v) { mySong8.start(); }
    public void playIT9(View v) { mySong9.start(); }
    public void playIT10(View v) { mySong10.start(); }
    public void playIT11(View v) { mySong11.start(); }
    public void playIT12(View v) { mySong12.start(); }


    @Override
    protected void onPause() {
        super.onPause();
        mySong1.release();
        mySong2.release();
        mySong3.release();
        mySong4.release();
        mySong5.release();
        mySong6.release();
        mySong7.release();
        mySong8.release();
        mySong9.release();
        mySong10.release();
        mySong11.release();
        mySong12.release();

    }

}
