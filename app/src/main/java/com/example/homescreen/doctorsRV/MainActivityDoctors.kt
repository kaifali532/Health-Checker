package com.example.homescreen.doctorsRV

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homescreen.R
import com.example.homescreen.databinding.ActivityMainBinding

class MainActivityDoctors : ComponentActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.doctors_activity_main)

        var rvDoctors = findViewById<RecyclerView>(R.id.rvDoctors)

        var doctorsList = mutableListOf(
            Doctors("Dr. Mitesh Dayal", "Psychiatrist", "12 years", "MBBS", "Rs. 800",
                R.drawable.doc_icon
            ),
            Doctors("Dr. Akash Garg", "Psychiatrist", "20 years", "MBBS, MD", "Rs. 1200",
                R.drawable.doc_icon
            ),
            Doctors("Dr. Abhijeet Kumar", "Psychiatrist", "10 years", "MBBS, DNB", "Rs. 1200",
                R.drawable.doc_icon
            ),
            Doctors("Dr. SP Sarkar", "Psychiatrist", "23 years", "MBBS, MD, MCCS", "Rs. 1000",
                R.drawable.doc_icon
            ),
            Doctors("Dr. Renu Lata", "Psychiatrist", "26 years", "MBBS", "Rs. 800", R.drawable.doc_icon),
            Doctors("Dr. Meenakshi M", "Psychiatrist", "15 years", "MBBS, DNB", "Rs. 1000",
                R.drawable.doc_icon
            ),
            Doctors("Dr. SK Sahoo", "Psychiatrist", "30 years", "MBBS, DNB", "Rs. 1200",
                R.drawable.doc_icon
            ),
            Doctors("Dr. Surjit Singh", "Psychiatrist", "46 years", "MBBS, MD", "Rs. 1000",
                R.drawable.doc_icon
            )
        )

        val adapter = DoctorsAdapter(doctorsList)
        rvDoctors.adapter = adapter
        rvDoctors.layoutManager = LinearLayoutManager(this)
    }

}


