package com.example.homescreen.Test

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homescreen.databinding.ActivityMainQuizBinding

class TestMainActivity: AppCompatActivity() {
    private lateinit var binding : ActivityMainQuizBinding

    private val questions = arrayOf("I found it hard to wind down", "I was aware of dryness of my mouth",
        "I couldn’t seem to experience any positive feeling", "I experienced breathing difficulty",
        "I found it difficult to work up the initiative", "I found it difficult to work up the initiative",
        "I experienced trembling ", "I felt that I was using a lot of nervous energy",
        "I was worried about situations in which I might panic", "I felt that I had nothing to look forward to ",
        "I found myself getting agitated", "I found it difficult to relax",
        "I felt down-hearted and blue", "I was intolerant of anything that kept me from getting on ",
        "I felt I was close to panic", "I was unable to become enthusiastic about anything",
        "I felt I wasn’t worth much as a person", "I felt that I was rather touchy",
        "I was aware of the action of my heart", "I felt scared without any good reason",
        "I felt that life was meaningless")

    private val options = arrayOf(arrayOf("Did not apply to me at all", "Applied to me to some degree",
        "Applied to me to a considerable degree", "Applied to me very much"))

    private val option1 = "Did not apply to me at all"
    private val option2 = "Applied to me to some degree"
    private val option3 = "Applied to me to a considerable degree"
    private val option4 = "Applied to me very much"

    private var currentQuestionIndex = 0
    private var questionNum = currentQuestionIndex+1
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestions()

        binding.btnOption1.setOnClickListener{
            selectedOption(0)
        }
        binding.btnOption2.setOnClickListener{
            selectedOption(1)
        }
        binding.btnOption3.setOnClickListener{
            selectedOption(2)
        }
        binding.btnOption4.setOnClickListener{
            selectedOption(3)
        }
        binding.buttonSubmit.setOnClickListener{
            nextQuestion()
        }
    }

    private fun selectedOption(buttonIndex : Int){
        when(buttonIndex){
            0->{
                binding.btnOption1.setBackgroundColor(Color.parseColor("#219EBC"))
            }
            1->{
                binding.btnOption2.setBackgroundColor(Color.parseColor("#219EBC"))
                score+=1
            }
            2->{
                binding.btnOption3.setBackgroundColor(Color.parseColor("#219EBC"))
                score+=2
            }
            3->{
                binding.btnOption4.setBackgroundColor(Color.parseColor("#219EBC"))
                score+=3
            }
        }
    }

    private fun resetButtonColors(){
        binding.btnOption1.setBackgroundColor(Color.TRANSPARENT)
        binding.btnOption2.setBackgroundColor(Color.TRANSPARENT)
        binding.btnOption3.setBackgroundColor(Color.TRANSPARENT)
        binding.btnOption4.setBackgroundColor(Color.TRANSPARENT)
    }

    private fun showResult(){
        Toast.makeText(this,"Your score : $score", Toast.LENGTH_LONG).show()
    }

    private fun displayQuestions(){
        binding.tvQuestion.text = questions[currentQuestionIndex]
        binding.btnOption1.text = option1
        binding.btnOption2.text = option2
        binding.btnOption3.text = option3
        binding.btnOption4.text = option4
        binding.tvQuestionNum.text = "Question $questionNum"
        binding.progressBar.progress=questionNum
        resetButtonColors()
    }

    private fun nextQuestion(){
        if(currentQuestionIndex < questions.size-1){
            currentQuestionIndex++
            questionNum++
            binding.tvQuestion.postDelayed({displayQuestions()}, 100)
        }else{
            showResult()
        }
    }

}
