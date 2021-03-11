package com.example.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            val t = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG)
            t.setGravity(Gravity.TOP, 0, 0)
            t.show()
        }

        falseButton.setOnClickListener {
            val t = Toast.makeText(this, R.string.false_toast, Toast.LENGTH_LONG)
            t.setGravity(Gravity.TOP, 0, 0)
            t.show()
        }
    }
}