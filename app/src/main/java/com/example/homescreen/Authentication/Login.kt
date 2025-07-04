package com.example.homescreen.Authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homescreen.MainActivity
import com.example.homescreen.R
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signUpButton: Button
    private lateinit var forgetPasswordButton: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emaillogin)
        passwordEditText = findViewById(R.id.firstpassword)
        loginButton = findViewById(R.id.loginbutton)
        signUpButton = findViewById(R.id.loginsingup)
        forgetPasswordButton = findViewById(R.id.forgetpassword)
        auth = FirebaseAuth.getInstance()

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }

        forgetPasswordButton.setOnClickListener {
            startActivity(Intent(this, Forgetpassword::class.java))
            finish()
        }

        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "sorry", Toast.LENGTH_LONG).show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                        Toast.makeText(this, "yes", Toast.LENGTH_LONG).show()
                    } else {
                        //Toast.makeText(this, getString(R.string.login_failed, task.exception?.message), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
