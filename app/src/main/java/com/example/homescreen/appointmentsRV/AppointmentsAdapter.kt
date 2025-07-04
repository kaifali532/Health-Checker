package com.example.homescreen.appointmentsRV

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homescreen.R


class AppointmentsAdapter(
    var appointments : MutableList<Appointments>
) : RecyclerView.Adapter<AppointmentsAdapter.AppointmentsViewHolder>(){
    inner class AppointmentsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_appointments, parent, false)
        return AppointmentsViewHolder(view)
    }

    @SuppressLint("WrongViewCast")
    override fun onBindViewHolder(holder: AppointmentsViewHolder, position: Int) {
        holder.itemView.apply {
            var tvName = findViewById<TextView>(R.id.tvName)
            val tvSpeciality = findViewById<TextView>(R.id.tvSpeciality)
            val tvDate = findViewById<TextView>(R.id.tvDate)
            val tvTime = findViewById<TextView>(R.id.tvTime)
            var ivImage = findViewById<ImageView>(R.id.ivImage)
            tvName.text = appointments[position].name
            tvSpeciality.text = appointments[position].speciality
            tvDate.text = appointments[position].date
            tvTime.text = appointments[position].time
            ivImage.setImageResource(appointments[position].image)
        }

    }


    override fun getItemCount(): Int {
        return appointments.size
    }
}