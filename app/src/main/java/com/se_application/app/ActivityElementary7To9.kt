package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityElementary7To9: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elementary_grade_7_9)
    }

    fun goBackToElementaryDashboard(view: View) {
        val intent = Intent(this, ActivityElementary::class.java)
        startActivity(intent)
    }
}