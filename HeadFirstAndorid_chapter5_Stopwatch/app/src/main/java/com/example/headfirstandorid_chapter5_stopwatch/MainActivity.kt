package com.example.headfirstandorid_chapter5_stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch : Chronometer
    var isRunning = false
    var offset : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stopwatch = findViewById(R.id.stopwatch)
        stopwatch.base = SystemClock.elapsedRealtime()

        val start = findViewById<Button>(R.id.start_bt)
        start.setOnClickListener{
            if(!isRunning) {
                setBaseTime()
                stopwatch.start()
                isRunning = true
            }
        }

        val stop = findViewById<Button>(R.id.pause_bt)
        stop.setOnClickListener {
            if(isRunning){
                saveOffset()
                stopwatch.stop()
                isRunning = false
            }
        }

        val reset = findViewById<Button>(R.id.reset_bt)
        reset.setOnClickListener {
            offset = 0
            setBaseTime()
            isRunning = false
        }
    }

    private fun setBaseTime(){
        stopwatch.base = SystemClock.elapsedRealtime() - offset
    }

    private fun saveOffset(){
        offset = SystemClock.elapsedRealtime() - stopwatch.base
    }
}