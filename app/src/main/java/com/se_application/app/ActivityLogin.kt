package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity


class ActivityLogin : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var forgetPass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        email = findViewById(R.id.myEmailText)
        password = findViewById(R.id.myTxtPassword)
        forgetPass = findViewById(R.id.txtForgotPassword)

        val message = intent.getStringExtra("message")
        if (message != null) {
            val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }

    }

    fun handleForgetPassword(view: View){
        email.setText("")
        password.setText("")
        Snackbar.make(view, "Please contact support for password reset", Snackbar.LENGTH_SHORT).show()
    }
    fun login(view: View) {
        // Get email and password from EditText fields
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        // Perform input validation
        if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
            Snackbar.make(view, "Please enter both email and password", Snackbar.LENGTH_SHORT).show()
            return
        }


        // Perform authentication
        if (authenticate(inputEmail, inputPassword)) {
            // Successful login, redirect to dashboard
            val username = email.text.toString().substringBefore("@")
            val intent = Intent(this, ActivityDashboard::class.java)
            intent.putExtra("message", "Logged in Successfully")
            intent.putExtra("username",username)
            startActivity(intent)

        } else {
            // Invalid credentials, show error message
            Snackbar.make(view, "Invalid email or password", Snackbar.LENGTH_SHORT).show()
        }


    }

    private fun authenticate(email: String, password: String): Boolean {
        // TODO: Perform actual authentication logic here
        return email == "user@s.com" && password == "pas"
    }

    fun goToSignup(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
    fun goToLogin(view: View) {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }


}