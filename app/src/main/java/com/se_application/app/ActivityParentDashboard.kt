package com.se_application.app

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ActivityParentDashboard : AppCompatActivity() {
    private lateinit var txtWelcomeuser: TextView

    private lateinit var adapter: StudentsListAdapter
    private lateinit var studentList: MutableList<Student>

    private lateinit var database: FirebaseDatabase
    private lateinit var studentsRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var userArrayList: ArrayList<Student>
    private lateinit var userRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_dashboard)
        val message = intent.getStringExtra("message")
        if (message != null) {
            val snackbar =
                Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", null)
        if (username != null) {
            txtWelcomeuser = findViewById(R.id.txtWelcomeuser)
            val welcomeText = "Welcome, ${username}!"
            txtWelcomeuser.text = welcomeText
            Log.d("username", username.toString())
        }


        userRecyclerView = findViewById(R.id.recyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)
        userArrayList = arrayListOf<Student>()
        getUserData()

    }
        private fun getUserData() {
            // usersRef.orderByChild("position").equalTo("parent")
            userRecyclerView.visibility = View.GONE
            studentsRef = FirebaseDatabase.getInstance().getReference("Student")
            usersRef = FirebaseDatabase.getInstance().getReference("User")

                usersRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        userArrayList.clear()
                        if (dataSnapshot.exists()) {
                            for (userSnapshot in dataSnapshot.children) {
                                val user = userSnapshot.getValue(User::class.java)
                                    val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                                    val username = sharedPref.getString("username", null)
                                    if (user != null && user.firstName == username && user.position == "Parent") {
                                        Log.d("dsa","dfad")
                                        studentsRef.addValueEventListener(object :
                                            ValueEventListener {
                                            override fun onDataChange(studentSnapshot: DataSnapshot) {
                                                for (studentSnapshot in studentSnapshot.children) {
                                                    val student =
                                                        studentSnapshot.getValue(Student::class.java)
                                                    if (student != null && student.middleNameStudent == user.firstName && student.lastNameStudent == user.lastName) {
                                                        userArrayList.add(student)
                                                    }

                                                }
                                                val mAdapter = StudentsListAdapter(userArrayList)
                                                userRecyclerView.adapter = mAdapter
                                                userRecyclerView.visibility = View.VISIBLE

                                            }

                                            override fun onCancelled(databaseError: DatabaseError) {
                                                // Handle error
                                            }
                                        })
                                        break
                                    }
                                }
                            }

                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                    }
                })

        }

}

