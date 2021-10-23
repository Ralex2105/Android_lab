package com.github.ralex2105.android_lab

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView

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
        backgroundThread.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SEC, secondsElapsed)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        secondsElapsed = savedInstanceState.getInt(SEC)
        super.onRestoreInstanceState(savedInstanceState)
    }

    /*
    override fun onResume() {
        val shared = this.getPreferences(Context.MODE_PRIVATE)
        secondsElapsed = shared.getInt(SEC, 0)
        super.onResume()
    }

    override fun onPause() {
        val shared = this.getPreferences(Context.MODE_PRIVATE)
        with(shared.edit()) {
            putInt(SEC, secondsElapsed)
            apply()
        }
        super.onPause()
    }
     */
}
