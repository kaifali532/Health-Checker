package com.example.homescreen

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homescreen.Authentication.Login
import com.example.homescreen.appointmentsRV.Prescription
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    lateinit var button2:Button
    lateinit var flb:FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        button2 = findViewById(R.id.button2)
        flb = findViewById(R.id.flb_ai)
        button2.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, Login::class.java))
            finish()
        }
        flb.setOnClickListener{
            val intent = Intent(this,AIActivity::class.java)
            startActivity(intent)
        }

        setCurrentFragment(firstFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miAppointment -> setCurrentFragment(secondFragment)
                R.id.miWorkshop -> setCurrentFragment(thirdFragment)
            }
            true
        }

        supportActionBar?.title = "Insightify"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#219EBC")))
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miProfile -> Intent(this, ProfileActivity::class.java).also { startActivity(it) }
            R.id.miNotifications -> Intent(
                this,
                NotificationsActivity::class.java
            ).also { startActivity(it) }

            R.id.miProgress -> Intent(this, ProgressActivity::class.java).also { startActivity(it) }
        }
        return true
    }

    fun showPrescription(view: View) {
        var Intent = Intent(this, Prescription::class.java).also { startActivity(it) }

    }
}


