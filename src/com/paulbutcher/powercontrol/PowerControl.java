package com.paulbutcher.powercontrol;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;

public class PowerControl extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void startImportant(View button) {
        PowerManager powerManager = (PowerManager)getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "PowerControl");
        wakeLock.acquire();
    }
    
    public void stopImportant(View button) {
        wakeLock.release();
    }
    
    private PowerManager.WakeLock wakeLock;
}
