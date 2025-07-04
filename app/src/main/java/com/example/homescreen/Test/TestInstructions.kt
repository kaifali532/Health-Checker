package com.example.homescreen.Test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.homescreen.R

class TestInstructions : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_test)
        var btnTest = findViewById<Button>(R.id.btnTest)
        btnTest.setOnClickListener{
            var intent = Intent(this, TestMainActivity::class.java)
            startActivity(intent)
        }
    }
}