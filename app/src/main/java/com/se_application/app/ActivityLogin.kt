package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ActivityLogin : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var loginButtonDone: Button
    private lateinit var signupButton: Button
    private lateinit var forgetPass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
    }


    fun goToSignup(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
    fun goToLogin(view: View) {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }
    fun goToDashboard(view: View) {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }
}