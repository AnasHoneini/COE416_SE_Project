package com.se_application.app

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale


class ActivityStudentList: AppCompatActivity() {
    private lateinit var textView: TextView
    lateinit var buttonClick: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var studentArrayList= ArrayList<Student>()
    private lateinit var adapter: ActivityStudentListAdaptor
    private var buttonText: String? = null // Declare buttonText variable here


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        textView = findViewById(R.id.dynamicTitle)
        buttonText = intent.getStringExtra("BUTTON_TEXT")
        textView.text = buttonText
        Log.d("ad",buttonText.toString())

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getStudentData()

        adapter = ActivityStudentListAdaptor(studentArrayList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }



    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Student>()


            for (i in studentArrayList) {


                if (i.firstNameStudent?.lowercase(Locale.ROOT)!!.contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                val rootView = findViewById<View>(android.R.id.content)
                Snackbar.make(rootView, "No Data found", Snackbar.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
                val mAdapter = ActivityStudentListAdaptor(filteredList as ArrayList<Student>)
                recyclerView.adapter = mAdapter
                recyclerView.visibility = View.VISIBLE
            }

        }
    }

    private fun getStudentData() {
        // Retrieve the data for the student nodes from Firebase
        val studentsRef = FirebaseDatabase.getInstance().getReference("Student")

        studentsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(studentSnapshot: DataSnapshot) {
                val buttonText = intent.getStringExtra("BUTTON_TEXT")
                val filteredStudents = studentSnapshot.children.filter { student ->
                    val studentClass = student.child("studentClass").value as String
                    val studentSection = student.child("studentSection").value as String
                    buttonText == studentClass + " " + studentSection
                }.mapNotNull { student ->
                    val studentData = student.getValue(Student::class.java)
                    val studentClass = student.child("studentClass").value as String
                    val studentSection = student.child("studentSection").value as String
                    studentData?.let { Student(it.lastNameStudent,studentClass, it.middleNameStudent,studentSection, it.firstNameStudent) }
                }
                studentArrayList.clear()
                studentArrayList.addAll(filteredStudents)

                val mAdapter = ActivityStudentListAdaptor(filteredStudents as ArrayList<Student>)
                recyclerView.adapter = mAdapter
                recyclerView.visibility = View.VISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(TAG, "Error retrieving student data: $databaseError")
            }
        })
    }








    fun goBackToParent(view: View) {
        val parentActivity = intent.getStringExtra("parent_activity")
        val destinationActivity = when (parentActivity) {
            "ActivityKindergarten" -> ActivityKindergarten::class.java
            "ActivityElementary1To6" -> ActivityElementary1To6::class.java
            "ActivityElementary7To9" -> ActivityElementary7To9::class.java
            "ActivityHighSchool" -> ActivityHighSchool::class.java
            else -> null
        }
        if (destinationActivity != null) {
            val intent = Intent(this, destinationActivity)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        } else {
            finish() // default behavior if no extra value is present
        }

    }

    fun goToReport(view: View) {
        val intent = Intent(this, ActivityReportList::class.java)
        intent.putExtra("BUTTON_TEXT", buttonText)
        startActivity(intent)

    }

    fun goToStudentList(view: View) {
        val intent = Intent(this, ActivityStudentList::class.java)
        startActivity(intent)
    }


}