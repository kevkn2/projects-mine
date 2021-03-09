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
    private lateinit var nextButton: Button
    private lateinit var beforeButton: Button
    private lateinit var questionTextView: TextView

    private val QuestionBank = listOf(
            question(R.string.question_australia, true),
            question(R.string.question_oceans, true),
            question(R.string.question_mideast, false),
            question(R.string.question_africa, false),
            question(R.string.question_americas, true),
            question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    val questionTextResId = QuestionBank[currentIndex].textResId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        beforeButton = findViewById(R.id.before_button)
        questionTextView = findViewById(R.id.questionTextView)
        questionTextView.setText(questionTextResId)

        trueButton.setOnClickListener {
            val t = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG)
            t.setGravity(Gravity.TOP, 0, 0)
            t.show()
        }

        falseButton.setOnClickListener {
            val t = Toast.makeText(applicationContext, R.string.false_toast, Toast.LENGTH_LONG)
            t.setGravity(Gravity.TOP, 0, 0)
            t.show()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % QuestionBank.size
            val questionTextResId = QuestionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
        }

        beforeButton.setOnClickListener{
            if(currentIndex > 0){
                currentIndex = (currentIndex - 1)
            }else {
                currentIndex = 5
            }
            val questionTextResId = QuestionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
        }
    }

    private fun checkAnswer(userAnswer: Boolean): Int {
        val correctAnswer: Boolean = QuestionBank[currentIndex].answer

        return if(userAnswer==correctAnswer){
            (R.string.correct_toast)
        }else{
            (R.string.false_toast)
        }
    }
}