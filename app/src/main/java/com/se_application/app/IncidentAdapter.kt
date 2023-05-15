package com.se_application.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IncidentAdapter (var incidentArray: ArrayList<Violence_record>) : RecyclerView.Adapter<IncidentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_listno,
            parent,false)
        return ViewHolder(itemView)
    }

    fun setFilteredList(incidentArray: ArrayList<Violence_record>){
        this.incidentArray = incidentArray
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem = incidentArray[position]

        holder.fname.text = currentitem.Std_fname
        holder.lname.text = currentitem.Std_lname
        holder.time.text = currentitem.time

    }

    override fun getItemCount(): Int {

        return incidentArray.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fname: TextView = itemView.findViewById(R.id.firstname)
        val lname: TextView = itemView.findViewById(R.id.lastname)
        val time: TextView = itemView.findViewById(R.id.time)

    }
}