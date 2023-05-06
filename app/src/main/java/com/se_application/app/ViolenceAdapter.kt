package com.se_application.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ViolenceAdapter(var violList: ArrayList<ViolenceData>) : RecyclerView.Adapter<ViolenceAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.violencepage,
            parent,false)
        return ViewHolder(itemView)
    }

    fun setFilteredList(violList: ArrayList<ViolenceData>){
        this.violList = violList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem = violList[position]

        holder.action.text = currentitem.action
        holder.incident.text = currentitem.incident.toString()
        holder.fname.text = currentitem.studentFirstName
        holder.lname.text = currentitem.studentLastName
        holder.time.text = currentitem.time

    }

    override fun getItemCount(): Int {

        return violList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val action: TextView = itemView.findViewById(R.id.action)
        val incident: TextView = itemView.findViewById(R.id.incidentName)
        val fname: TextView = itemView.findViewById(R.id.fname)
        val lname: TextView = itemView.findViewById(R.id.lname)
        val time: TextView = itemView.findViewById(R.id.time)

    }
}