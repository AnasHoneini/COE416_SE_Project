package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class ActivityKindergarten: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kindergarten)


    }

    fun goBackToDashboard(view: View) {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }

    fun goToStudentList(view: View) {
        val buttonText = (view as AppCompatButton).text.toString()
        val intent = Intent(this, ActivityStudentList::class.java)
        intent.putExtra("BUTTON_TEXT", buttonText)
        intent.putExtra("parent_activity", "ActivityKindergarten")
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