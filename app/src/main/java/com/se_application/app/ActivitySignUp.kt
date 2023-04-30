package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivitySignUp: AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        nameEditText = findViewById(R.id.myUserName)
        emailEditText = findViewById(R.id.textEmail)
        passwordEditText = findViewById(R.id.myPassword)
        signupButton = findViewById(R.id.btnSignupDone)


    }
    fun goToLogin(view: View) {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }

    fun goToSignup(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
}
