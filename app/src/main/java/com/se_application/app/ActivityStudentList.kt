package com.se_application.app

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
    private lateinit var addsBtn: FloatingActionButton
    private var studentGrade: String?= null
    private var section: String?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        textView = findViewById(R.id.dynamicTitle)
        buttonText = intent.getStringExtra("BUTTON_TEXT")
        textView.text = buttonText
        Log.d("ad",buttonText.toString())

        addsBtn = findViewById(R.id.addingBtn)
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getStudentData()



        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }


        adapter = ActivityStudentListAdaptor(this, studentArrayList)
        recyclerView.adapter = adapter
        getStudentData()



    }

    fun writeStudentData(fname: String, mname: String, lname: String) {

        // get reference to the "Student" node in Firebase Realtime Database
        val database = FirebaseDatabase.getInstance()
        val studentRef = database.getReference("Student")
            // create a new unique key for the student data
            val studentKey = studentRef.push().key

            // create a Student object with the given data
            val student = Student(lname, section, mname, studentGrade, fname)

            // write the student data to the database using the unique key
            if (studentKey != null) {
                studentRef.child(studentKey).setValue(student)
                    .addOnSuccessListener {
                        // data was successfully written to Firebase
                        val rootView = findViewById<View>(android.R.id.content)

                        Snackbar.make(rootView,"Student data was written to Firebase", Snackbar.LENGTH_SHORT).show()

                    }
                    .addOnFailureListener {
                        val rootView = findViewById<View>(android.R.id.content)

                        Snackbar.make(rootView,"Error writing student data to Firebase", Snackbar.LENGTH_SHORT).show()

                    }
            }
        }


    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)

        /**set view*/
        val firstName: EditText = v.findViewById<EditText>(R.id.firstName)
        val middleName: EditText = v.findViewById<EditText>(R.id.middleName)
        val lastName: EditText = v.findViewById<EditText>(R.id.lastName)

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val firstName = firstName.text.toString()
            val middleName = middleName.text.toString()
            val lastName = lastName.text.toString()


            studentArrayList.add(Student("$lastName", section,"$middleName", studentGrade,"$firstName"))
            adapter.notifyDataSetChanged()
            writeStudentData(firstName,middleName,lastName)
            val rootView = findViewById<View>(android.R.id.content)
            Snackbar.make(rootView,"Adding User Information Success", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
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
                val mAdapter = ActivityStudentListAdaptor(this, filteredList as ArrayList<Student>)
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
                    studentGrade=studentClass
                    section = studentSection
                    buttonText == studentClass + " " + studentSection
                }.mapNotNull { student ->
                    val studentData = student.getValue(Student::class.java)
                    val studentClass = student.child("studentClass").value as String
                    val studentSection = student.child("studentSection").value as String
                    studentData?.let { Student(it.lastNameStudent,studentClass, it.middleNameStudent,studentSection, it.firstNameStudent) }
                }
                studentArrayList.clear()
                studentArrayList.addAll(filteredStudents)

                val mAdapter = ActivityStudentListAdaptor(this@ActivityStudentList, filteredStudents as ArrayList<Student>)
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