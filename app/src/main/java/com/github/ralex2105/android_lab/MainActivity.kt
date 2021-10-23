package com.github.ralex2105.android_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity_lifecycle", "Crate activity")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity_lifecycle", "Start activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity_lifecycle", "Resume activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity_lifecycle", "Paused activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity_lifecycle", "Stop activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity_lifecycle", "Destroy activity")
    }
}
