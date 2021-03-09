package com.example.wouldyou

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonYes = findViewById<Button>(R.id.buttonYes)
        val buttonNo = findViewById<Button>(R.id.buttonNo)

        buttonNo?.setOnClickListener(){
            Toast.makeText(this@MainActivity, R.string.no, Toast.LENGTH_SHORT).show()
        }
        buttonYes?.setOnClickListener(){
            Toast.makeText(this@MainActivity, R.string.yes, Toast.LENGTH_SHORT).show()
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, R.string.no, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        val activityManager = applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.moveTaskToFront(taskId, 0)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        hideNavigationBar()
    }
    private fun hideNavigationBar() {
        val decorView: View = this.window.decorView
        val uiOptions: Int = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        val timer = Timer()
        val task: TimerTask = object : TimerTask() {
            override fun run() {
                runOnUiThread { decorView.setSystemUiVisibility(uiOptions) }
            }
        }
        timer.scheduleAtFixedRate(task, 0, 20)
    }
}