package com.example.myplyaer;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class PlayerManager implements SurfaceHolder.Callback{

    static {
        System.loadLibrary("myplayer");
    }

    private SurfaceHolder surfaceHolder;

    public void setSurfaceView(SurfaceView surfaceView) {
        if (null != this.surfaceHolder) {
            this.surfaceHolder.removeCallback(this);
        }
        this.surfaceHolder = surfaceView.getHolder();
        this.surfaceHolder.addCallback(this);

    }

    public void start(String path) {
        native_start(path,surfaceHolder.getSurface());
    }
    public native void native_start(String path, Surface surface);

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
