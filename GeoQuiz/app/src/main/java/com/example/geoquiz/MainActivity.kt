package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : QuizViewModel

    private lateinit var questionTextView : TextView

    private lateinit var trueButton : Button
    private lateinit var falseButton : Button
    private lateinit var previousButton : ImageView
    private lateinit var nextButton : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        questionTextView = findViewById(R.id.tv_question)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)

        questionUpdate()


        trueButton.setOnClickListener {
            changeButtonsClickable(clickable = false)
            viewModel.takeAnswer(true)
        }

        falseButton.setOnClickListener {
            changeButtonsClickable(clickable = false)
            viewModel.takeAnswer(false)
        }

        previousButton.setOnClickListener {
            viewModel.moveToBack()
            viewModel.pointMoveBack()
            changeClickable()
            questionUpdate()
        }

        nextButton.setOnClickListener {
            viewModel.moveToNext()
            viewModel.pointMoveNext()
            changeClickable()
            questionUpdate()
        }


    }

    private fun questionUpdate(){
        val questionResId = viewModel.currentQuestionResID
        questionTextView.setText(questionResId)

        if(viewModel.isTestingEnd())
            Toast.makeText(this, "You take a ${viewModel.countOfRightAnswers()} right answers from ${viewModel.currentCountQuestions}", Toast.LENGTH_SHORT).show()
    }

    private fun changeClickable() : Boolean{
        return if(viewModel.isRightUserAnswer == null) changeButtonsClickable(clickable = true)
               else changeButtonsClickable(clickable = false)
    }

    private fun changeButtonsClickable(clickable : Boolean) : Boolean{
        trueButton.isClickable = clickable
        falseButton.isClickable = clickable
        return clickable
    }


}