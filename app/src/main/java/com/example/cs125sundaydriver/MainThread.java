package com.example.cs125sundaydriver;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    public static final int Max_FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private gameplay gamePanel;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, gameplay gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        long starttime;
        long timeMillis = 1000/Max_FPS;
        long waittime;
        int framecount = 0;
        long totaltime = 0;
        long targettime = 1000/Max_FPS;

        while(running) {
            starttime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeMillis = (System.nanoTime() - starttime)/1000000;
            waittime = targettime - timeMillis;
            try {
                if (waittime > 0)
                    this.sleep(waittime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            totaltime += System.nanoTime() - starttime;
            framecount++;
        }
    }
}
