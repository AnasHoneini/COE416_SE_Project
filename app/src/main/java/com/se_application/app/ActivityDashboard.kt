package com.se_application.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ActivityDashboard : AppCompatActivity() {
    private lateinit var txtWelcomeuser: TextView


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