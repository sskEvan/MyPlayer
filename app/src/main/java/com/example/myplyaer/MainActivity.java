package com.example.myplyaer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    PlayerManager playerManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager
                .LayoutParams.FLAG_KEEP_SCREEN_ON);
        surfaceView = findViewById(R.id.surfaceView);
        playerManager = new PlayerManager();
        playerManager.setSurfaceView(surfaceView);
    }


    public void open(View view) {
        String dir = Environment.getExternalStorageDirectory()+ "/ffmpeg";
        File file = new File(dir, "input.mp4");
        String path = file.getAbsolutePath();
        boolean exist = file.exists();
        playerManager.start(path);
    }

}