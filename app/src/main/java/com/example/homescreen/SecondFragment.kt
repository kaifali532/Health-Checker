package com.example.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homescreen.appointmentsRV.Appointments
import com.example.homescreen.appointmentsRV.AppointmentsAdapter
import com.example.homescreen.databinding.SecondFragmentBinding

class SecondFragment : Fragment(R.layout.second_fragment) {
    private lateinit var adapter : AppointmentsAdapter
    private lateinit var binding : SecondFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        var rvAppointments = binding.rvAppointments
        var AppointmnetsList = mutableListOf(
            Appointments("Dr. MK Sharma", "Psychiatrist", "10/1/24", "12:00 pm",R.drawable.doc_icon),
            Appointments("Dr. Mitesh Dayal", "Psychiatrist", "5/2/24", "10:00 am",R.drawable.doc_icon),
            Appointments("Dr. Akash Garg", "Psychiatrist", "10/2/24", "8:00 pm",R.drawable.doc_icon),
            Appointments("Dr. Abhijeet Kumar", "Psychiatrist", "21/3/24", "5:00 pm",R.drawable.doc_icon),
            Appointments("Dr. Renu Lata", "Psychiatrist", "7/4/24", "11:00 am",R.drawable.doc_icon),

            )


        val adapter = AppointmentsAdapter(AppointmnetsList)
        rvAppointments.adapter = adapter
        rvAppointments.layoutManager = LinearLayoutManager(context)

        return binding.root


        }
    }





