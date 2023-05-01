package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityElementary: AppCompatActivity() {
    private lateinit var txtWelcomeuser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elementary)
        val username = intent.getStringExtra("username")
        txtWelcomeuser = findViewById(R.id.txtWelcomeuser)
        val welcomeText = "Welcome, ${username.toString()}!"
        txtWelcomeuser.text = welcomeText
    }

    fun goBackToDashboard(view: View) {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }

    fun goToGrades16(view: View) {
        val intent = Intent(this, ActivityElementary1To6::class.java)
        startActivity(intent)
    }
    fun goToGrades79(view: View) {
        val intent = Intent(this, ActivityElementary7To9::class.java)
        startActivity(intent)
    }
}