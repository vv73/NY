package ru.itx.ny;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView bell;
    TextView con;
    Animation bellanim;
    MediaPlayer mp;
    boolean isPlay=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bellanim= AnimationUtils.loadAnimation(this,R.anim.bell_anim);
        con=(TextView)findViewById(R.id.con);
        setContentView(R.layout.activity_main);
    }

    public void gou(View view) {
        bell.startAnimation(bellanim);
        if (isPlay) return;
        mp = MediaPlayer.create(this, R.raw.jb);
        mp.start();
        isPlay = true;
        con.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onPause()
    {
        if (mp != null && mp.isPlaying())
            mp.pause();
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        if (mp != null && isPlay)
            mp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy()
    {
        if (mp != null)
        {
            mp.release();
            mp = null;
        }
        super.onDestroy();
    }
}
