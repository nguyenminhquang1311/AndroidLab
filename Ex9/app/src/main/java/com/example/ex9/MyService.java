package com.example.ex9;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    private MediaPlayer mymedia;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Tạo MediaPlayer từ file seeu.mp3 trong res/raw
        mymedia = MediaPlayer.create(this, R.raw.sample3);
        if (mymedia != null) {
            mymedia.setLooping(true);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mymedia != null) {
            if (mymedia.isPlaying()) {
                mymedia.pause();
            } else {
                mymedia.start();
            }
        }
        return START_STICKY; // Giúp service tiếp tục chạy
    }

    @Override
    public void onDestroy() {
        if (mymedia != null) {
            if (mymedia.isPlaying()) {
                mymedia.stop();
            }
            mymedia.release();
            mymedia = null;
        }
        super.onDestroy();
    }
}
