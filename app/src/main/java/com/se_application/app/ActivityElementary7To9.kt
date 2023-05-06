package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivityElementary7To9: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elementary_grade_7_9)
    }

    fun goBackToElementaryDashboard(view: View) {
        val intent = Intent(this, ActivityElementary::class.java)
        startActivity(intent)
    }

    fun goToStudentList(view: View) {
        val buttonText = (view as AppCompatButton).text.toString()
        val intent = Intent(this, ActivityStudentList::class.java)
        intent.putExtra("BUTTON_TEXT", buttonText)
        intent.putExtra("parent_activity", "ActivityElementary7To9")
        startActivity(intent)

    }

    fun goToReport(view: View) {
        val buttonText = (view as AppCompatButton).text.toString()
        val intent = Intent(this, ActivityStudentList::class.java)
        intent.putExtra("BUTTON_TEXT", buttonText)
        intent.putExtra("parent_activity", "ActivityElementary1To6")
        startActivity(intent)

    }
}