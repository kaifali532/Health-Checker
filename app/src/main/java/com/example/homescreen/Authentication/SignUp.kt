package com.example.homescreen.Authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homescreen.MainActivity
import com.example.homescreen.R
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var moveToLoginButton: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        signUpButton = findViewById(R.id.button)
        moveToLoginButton = findViewById(R.id.movetologin)

        auth = FirebaseAuth.getInstance()

        moveToLoginButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        signUpButton.setOnClickListener {
            performSignup()
        }
    }
    private fun performSignup() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Sorry", Toast.LENGTH_LONG).show()
        } else {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "successful", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Log.w(TAG, "Signup failure", task.exception)
                       // Toast.makeText(this, getString("get", task.exception?.message), Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
    companion object {
        private const val TAG = "SignUpActivity"
    }
}


