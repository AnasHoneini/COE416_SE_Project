package com.se_application.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ActivityDashboard : AppCompatActivity() {
    private lateinit var txtWelcomeuser: TextView
    private var incidentArrayList= ArrayList<Violence_record>()
    private lateinit var adapter: IncidentAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val message = intent.getStringExtra("message")
        if (message != null) {
            val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
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
        recyclerView = findViewById(R.id.recyclerView)
        readFromFirebase()
        adapter = IncidentAdapter(incidentArrayList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }




        fun readFromFirebase() {
        val database = FirebaseDatabase.getInstance().getReference("Violence_record")
        Log.d("why","no")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childSnapshot in dataSnapshot.children) {
                    val incident = childSnapshot.child("incident").getValue(Boolean::class.java)
                    Log.d("lkkk","no")

                    if (incident == true) {
                        Log.d("l","no")

                        val firstName = childSnapshot.child("Std_fname").getValue(String::class.java)
                        val lastName = childSnapshot.child("Std_lname").getValue(String::class.java)
                        val time = childSnapshot.child("time").getValue(String::class.java)
                        val isNewRecord = !incidentArrayList.any { it.Std_fname == firstName.toString() && it.Std_lname == lastName.toString() && it.incident && it.time == time.toString() }

                        if (isNewRecord) {
                            incidentArrayList.add(
                                Violence_record(
                                    firstName.toString(),
                                    lastName.toString(),
                                    true,
                                    time.toString()
                                )
                            )

                        }
                    }
                }
                val mAdapter = IncidentAdapter(incidentArrayList)
                Log.d("inc", incidentArrayList.toString())
                recyclerView.adapter = mAdapter
                recyclerView.visibility = View.VISIBLE
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                println("Firebase read failed: " + error.message)
            }
        })
    }



    fun goToKindergarten(view: View) {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, ActivityKindergarten::class.java)
        intent.putExtra("username",username)
        startActivity(intent)

    }
    fun goToElementary(view: View) {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, ActivityElementary::class.java)
        intent.putExtra("username",username)
        startActivity(intent)
    }
    fun goToHighSchool(view: View) {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, ActivityHighSchool::class.java)
        intent.putExtra("username",username)
        startActivity(intent)
    }



}