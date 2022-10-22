package com.example.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    var pointOfView : Int = 0
    private var currentIndex : Int = 0
    private val questionBank = listOf(
        Question(R.string.question_australia, true, null),
        Question(R.string.question_oceans, true, null),
        Question(R.string.question_mideast, false, null),
        Question(R.string.question_africa, false, null),
        Question(R.string.question_americas, true, null),
        Question(R.string.question_asia, true, null)
    )

    val currentCountQuestions : Int get() = questionBank.size
    val currentQuestionResID : Int get() = questionBank[currentIndex].textResId
    val currentQuestionAnswer : Boolean get() = questionBank[currentIndex].answer
    val isRightUserAnswer : Boolean? get() = questionBank[currentIndex].userAnswer

    fun moveToNext(){
        currentIndex = (++currentIndex) % questionBank.size
    }

    fun moveToBack(){
        if (currentIndex - 1 < 0) {
            currentIndex = questionBank.size - 1
        }
        else
            currentIndex--
    }

    fun pointMoveNext() : Boolean{
        pointOfView++
        return if(pointOfView < questionBank.size) true
               else { pointOfView = 0; false }
    }

    fun pointMoveBack() : Boolean{
        pointOfView--
        return if(-pointOfView < questionBank.size) true //////////////////////////////////// Is the original pointOfView becoming a positive number?
               else { pointOfView = 0; false }
    }

    fun isTestingEnd() : Boolean{
        var answer : Boolean = true

        for (i in questionBank)
            if (i.userAnswer==null) {
                answer = false
                break
            }

        return answer
    }

    fun countOfRightAnswers() : Int{
        var answer : Int = 0

        for(i in questionBank){
            if(i.userAnswer == null){
                answer = -1
                break
            }
            if(i.userAnswer == true){
                answer++
            }
        }

        return answer
    }

    fun takeAnswer(userAnswer: Boolean){
        questionBank[currentIndex].userAnswer = userAnswer == questionBank[currentIndex].answer
    }

    fun checkAnswer() : Boolean{
        return questionBank[currentIndex].userAnswer == questionBank[currentIndex].answer

    }

}