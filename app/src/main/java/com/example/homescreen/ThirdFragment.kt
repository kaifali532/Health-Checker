package com.example.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homescreen.databinding.ThirdFragmentBinding
import com.example.homescreen.workshopsRV.Workshops
import com.example.homescreen.workshopsRV.WorkshopsAdapter

class ThirdFragment : Fragment(R.layout.third_fragment) {

    private lateinit var adapter : WorkshopsAdapter
    private lateinit var binding : ThirdFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ThirdFragmentBinding.inflate(inflater, container, false)
        var rvWorkshops = binding.rvWorkshops
        var WorkshopsList = mutableListOf(
            Workshops("Mental Health","By : Dr. SK Mittal" ,"30/5/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon),
            Workshops("Depression & Cure", "By : Dr. Om Mathur","5/6/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon),
            Workshops("Child Health", "By : Dr. Ajay Singh","11/6/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon),
            Workshops("Anxiety Attacks", "By : Dr. Vishal Sharma","20/6/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon),
            Workshops("Old Age", "By : Dr. Omesh Shah","27/6/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon),
            Workshops("Work Life", "By : Dr, NP Singh","3/7/24", "11:00 am", "Rs.1500", R.drawable.workshop_icon)

            )


        val adapter = WorkshopsAdapter(WorkshopsList)
        rvWorkshops.adapter = adapter
        rvWorkshops.layoutManager = LinearLayoutManager(context)

        return binding.root


    }
}