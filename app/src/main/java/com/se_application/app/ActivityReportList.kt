package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityReportList: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reports)

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