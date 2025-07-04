package com.example.homescreen

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.ai.client.generativeai.GenerativeModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.runBlocking

class AIActivity  : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var send:FloatingActionButton
    lateinit var moveback:FloatingActionButton
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai)
        editText = findViewById(R.id.edittext)
        send = findViewById(R.id.send)
        textView = findViewById(R.id.textview_name)

        send.setOnClickListener{
            val editText = editText.text.toString()

            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = "AIzaSyCeO6OwQ_r5Kvz3DzOBbMIyx8dvOLl138U"
            )

            runBlocking {
                val response = generativeModel.generateContent(editText)
                textView.text = response.text

            }
        }
    }
}