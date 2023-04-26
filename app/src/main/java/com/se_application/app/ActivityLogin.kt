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

        username = findViewById(R.id.myEditText)
        password = findViewById(R.id.myTxtPassword)
        loginButton = findViewById(R.id.btnLoginPage)
        loginButtonDone = findViewById(R.id.btnLoginDone)
        signupButton = findViewById(R.id.btnSignupPage)
        forgetPass = findViewById(R.id.txtForgotPassword)

        loginButtonDone.setOnClickListener {
            val inputUsername = username.text.toString().trim()
            val inputPassword = password.text.toString().trim()

            if (inputUsername.isEmpty()) {
                username.error = "Please enter your username"
                return@setOnClickListener
            }

            if (inputPassword.isEmpty()) {
                password.error = "Please enter your password"
                return@setOnClickListener
            }

            // Perform login operation here
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        }

        signupButton.setOnClickListener {
            // Launch signup activity here

            Toast.makeText(this, "Launching signup activity", Toast.LENGTH_SHORT).show()
        }

        forgetPass.setOnClickListener {
            // Perform forgot password operation here
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
        }
    }

    fun goToLogin(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
    fun goToSignup(view: View) {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }
}