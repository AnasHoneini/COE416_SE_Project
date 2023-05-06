package com.se_application.app

import android.content.Context
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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale

class ActivityParentDashboard : AppCompatActivity() {
    private lateinit var txtWelcomeuser: TextView
    private lateinit var database: FirebaseDatabase
    private lateinit var studentsRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private var userArrayList= ArrayList<User>()
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var studentArrayList= ArrayList<Student>()
    private lateinit var adapter: StudentsListParentAdapter


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
        val btnSignOut = findViewById<Button>(R.id.btn_signout)
        btnSignOut.setOnClickListener {
            val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }


        userRecyclerView = findViewById(R.id.recyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        searchView = findViewById(R.id.searchView)
        userRecyclerView.setHasFixedSize(true)
        getUserData()
        adapter = StudentsListParentAdapter(studentArrayList)
        userRecyclerView.adapter = adapter



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
                val mAdapter = StudentsListParentAdapter(filteredList as ArrayList<Student>)
                userRecyclerView.adapter = mAdapter
                userRecyclerView.visibility = View.VISIBLE
            }

        }
    }


    private fun getUserData() {
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
                            val studentQuery = studentsRef.orderByChild("middleNameStudent").equalTo(user.firstName)
                            studentQuery.addValueEventListener(object :
                                ValueEventListener {
                                override fun onDataChange(studentSnapshot: DataSnapshot) {
                                    for (studentSnapshot in studentSnapshot.children) {
                                        val student =
                                            studentSnapshot.getValue(Student::class.java)
                                        if (student != null && student.lastNameStudent == user.lastName) {
                                            studentArrayList.add(student)
                                        }
                                    }
                                    Log.d("arr",userArrayList.toString())
                                    Log.d("arrstu",studentArrayList.toString())
                                    val mAdapter = StudentsListParentAdapter(studentArrayList)
                                    Log.d("size", mAdapter.getItemCount().toString())
                                    userRecyclerView.adapter = mAdapter
                                    userRecyclerView.visibility = View.VISIBLE
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    // Handle error
                                }
                            })
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }

    fun goToSupervisor(view: View) {
        val intent = Intent(this, ActivitySupervisor::class.java)
        startActivity(intent)
    }


}

