package com.se_application.app

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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


class ActivityReportList: AppCompatActivity() {
    private lateinit var textView: TextView
    lateinit var buttonClick: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var studentArrayList= ArrayList<ViolenceData>()
    private lateinit var adapter: ViolenceAdapter
    private var buttonText: String? = null // Declare buttonText variable here


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reports)
        textView = findViewById(R.id.dynamicTitle)
        buttonText = intent.getStringExtra("BUTTON_TEXT")
        textView.text = buttonText
        Log.d("ad",buttonText.toString())


        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getStudentData()
        adapter = ViolenceAdapter(studentArrayList)
        recyclerView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                Log.d("dddddddatttta","as")
                return true
            }

        })



    }

    private fun filterList(query: String?) {
        Log.d("datttta","as")

        if (query != null) {
            val filteredList = ArrayList<ViolenceData>()
            Log.d("array",studentArrayList.toString())

            for (i in studentArrayList) {
                Log.d("dataaa",i.toString())

                if (i.studentFirstName?.lowercase(Locale.ROOT)!!.contains(query)) {
                    Log.d("data",i.studentFirstName.toString())
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
        val violenceDataRef = FirebaseDatabase.getInstance().getReference("ViolenceData")
        Log.d("wow","wow")
        violenceDataRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(violenceDataSnapshot: DataSnapshot) {
                studentsRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(studentSnapshot: DataSnapshot) {
                        for (violenceDataSnapshotChild in violenceDataSnapshot.children) {
                            // Get the student first and last name from the violenceData node
                            val studentFirstName = violenceDataSnapshotChild.child("studentFirstName").value as String
                            val studentLastName = violenceDataSnapshotChild.child("studentLastName").value as String
                            Log.d("f", studentFirstName)
                            Log.d("l", studentLastName)

                            // Match the first and last name of the student in the ViolenceData node with the student name in the Student node
                            var studentNode: DataSnapshot? = null
                            for (studentSnapshotChild in studentSnapshot.children) {
                                Log.d("ok","ok")
                                if (studentSnapshotChild.child("firstNameStudent").value == studentFirstName &&
                                    studentSnapshotChild.child("lastNameStudent").value == studentLastName) {
                                    Log.d("sad","das")
                                    studentNode = studentSnapshotChild
                                    break
                                }
                            }

                            if (studentNode != null) {
                                val studentClass = studentNode.child("studentClass").value as String
                                val studentSection = studentNode.child("studentSection").value as String
                                Log.d("c", studentClass)
                                Log.d("s", studentSection)
                                // Match the student class and section with the button text
                                val buttonText = intent.getStringExtra("BUTTON_TEXT")
                                Log.d("button",buttonText.toString())
                                if (buttonText == studentClass + " " + studentSection) {
                                    // Add the violence data to the filtered list
                                    val violenceData = violenceDataSnapshotChild.getValue(ViolenceData::class.java)
                                    Log.d("viol",violenceData.toString())
                                    if (violenceData != null) {
                                        studentArrayList.add(violenceData)
                                    }
                                }
                                Log.d("dddd",studentArrayList.toString())

                                val mAdapter = ViolenceAdapter(studentArrayList)
                                Log.d("sizestu", mAdapter.getItemCount().toString())
                                recyclerView.adapter = mAdapter
                                recyclerView.visibility = View.VISIBLE
                            }
                        }
                    }

                    override fun onCancelled(studentError: DatabaseError) {
                        Log.d(TAG, "Error retrieving student data: $studentError")
                    }
                })
            }

            override fun onCancelled(violenceDataError: DatabaseError) {
                Log.d(TAG, "Error retrieving violence data: $violenceDataError")
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
        startActivity(intent)
    }

    fun goToStudentList(view: View) {
        val intent = Intent(this, ActivityStudentList::class.java)
        startActivity(intent)
    }
}