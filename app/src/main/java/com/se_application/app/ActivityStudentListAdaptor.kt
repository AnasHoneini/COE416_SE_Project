package com.se_application.app

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class ActivityStudentListAdaptor(val c: Context, var studentsList: ArrayList<Student>) : RecyclerView.Adapter<ActivityStudentListAdaptor.ViewHolder>() {

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
        holder.fname.text = student.firstNameStudent
        holder.sname.text = student.middleNameStudent
        holder.lname.text = student.lastNameStudent
        Log.d("fulname",fullName)
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var fname:TextView
        var sname: TextView
        var lname: TextView
        var mMenus:ImageView

        init{
            fname = itemView.findViewById(R.id.fname)
            sname = itemView.findViewById(R.id.sname)
            lname = itemView.findViewById(R.id.lname)
            mMenus = itemView.findViewById(R.id.mMenus)
            mMenus.setOnClickListener{ popupMenu(it) }
        }

        private fun popupMenu(v:View) {
            val position = studentsList[adapterPosition]
            val popupMenus = PopupMenu(c,v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {
                        val v = LayoutInflater.from(c).inflate(R.layout.add_item, null)
                        val firstName = v.findViewById<EditText>(R.id.firstName)
                        val middleName = v.findViewById<EditText>(R.id.middleName)
                        val lastName = v.findViewById<EditText>(R.id.lastName)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok") { dialog, _ ->
                                position.firstNameStudent = firstName.text.toString()
                                position.middleNameStudent = middleName.text.toString()
                                position.lastNameStudent = lastName.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(c, "User Information is Edited", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel") { dialog, _ ->
                                dialog.dismiss()

                            }
                            .create()
                            .show()

                        true
                    }
                    R.id.delete -> {
                        /**set delete*/
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_warning)
                            .setMessage("Are you sure delete this?")
                            .setPositiveButton("Yes") { dialog, _ ->
                                studentsList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Deleted this Information", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()

                        true
                    }
                    else -> true
                }
            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(menu,true)
        }

    }
}
