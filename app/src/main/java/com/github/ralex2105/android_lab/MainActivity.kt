package com.github.ralex2105.android_lab

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences


    companion object {
        const val SEC = "sec"
    }
    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences("SEC", Context.MODE_PRIVATE)
        backgroundThread.start()
    }

    override fun onStart() {
        secondsElapsed = sharedPref.getInt("SEC", 0)
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        val sharedPref = sharedPref.edit()
        sharedPref.putInt("SEC", secondsElapsed)
        sharedPref.apply()
    }
}