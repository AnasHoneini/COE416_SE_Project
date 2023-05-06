package com.se_application.app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityStudentListAdaptor(var studentsList: ArrayList<Student>) : RecyclerView.Adapter<ActivityStudentListAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_page_list, parent, false)
        return ViewHolder(view)

    }

    fun setFilteredList(studentsList: ArrayList<Student>){
        this.studentsList = studentsList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentsList[position]
        val fullName = "${student.firstNameStudent} ${student.middleNameStudent} ${student.lastNameStudent}"
        holder.firstname.text = student.firstNameStudent
        holder.secondName.text = student.middleNameStudent
        holder.lastname.text = student.lastNameStudent
        Log.d("fulname",fullName)
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val secondName: TextView = itemView.findViewById(R.id.sname)
        val firstname: TextView = itemView.findViewById(R.id.fname)
        val lastname: TextView = itemView.findViewById(R.id.lname)
        }
}
