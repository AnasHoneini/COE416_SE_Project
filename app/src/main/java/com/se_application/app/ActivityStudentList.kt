package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ActivityStudentList: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

    }

    fun goBackToParent(view: View) {
        val intent = Intent(this, ActivityKindergarten::class.java)
        startActivity(intent)
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