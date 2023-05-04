package com.se_application.app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class StudentsListAdapter(private val studentsList: ArrayList<Student>) : RecyclerView.Adapter<StudentsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentsList[position]
        val fullName = "${student.firstNameStudent} ${student.middleNameStudent} ${student.lastNameStudent}"
        holder.firstNameTextView.text = student.firstNameStudent
        holder.middleNameTextView.text = student.middleNameStudent
        holder.lastNameTextView.text = student.lastNameStudent
        holder.classTextView.text = student.studentClass
        holder.sectionTextView.text = student.studentSection
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstNameTextView: TextView = itemView.findViewById(R.id.firstNameTextView)
        val middleNameTextView: TextView = itemView.findViewById(R.id.middleNameTextView)
        val lastNameTextView: TextView = itemView.findViewById(R.id.lastNameTextView)
        val classTextView: TextView = itemView.findViewById(R.id.classTextView)
        val sectionTextView: TextView = itemView.findViewById(R.id.sectionTextView)
    }
}
