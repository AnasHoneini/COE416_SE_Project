package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityHighSchool: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highschool_10_12)

    }

    fun goBackToDashboard(view: View) {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }
}