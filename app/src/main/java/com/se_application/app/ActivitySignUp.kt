package com.se_application.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ActivitySignUp: AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var positionSupervisor: RadioButton
    private lateinit var positionParent: RadioButton
    private var selectedPosition = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        FirebaseAuth.getInstance()




        username = findViewById(R.id.myUserName)
        email = findViewById(R.id.textEmail)
        password = findViewById(R.id.myPassword)
        confirmPassword = findViewById(R.id.ConfirmPassword)
        positionSupervisor = findViewById(R.id.radio_button_1)
        positionParent = findViewById(R.id.radio_button_2)
        val radioGroup = findViewById<RadioGroup>(R.id.my_radio_group)


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // check which radio button was clicked
            when (checkedId) {
                positionSupervisor.id -> {
                    // set selected position to supervisor
                    selectedPosition = "Supervisor"
                }
                positionParent.id -> {
                    // set selected position to parent
                    selectedPosition = "Parent"
                }
            }
        }

    }

    private fun validateInput(): Boolean {
        var isValid = true

        // Check if username is empty
        if (username.text.isNullOrEmpty()) {
            username.error = "Please enter your username"
            isValid = false
        }

        // Check if email is empty or invalid
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (email.text.isNullOrEmpty() || !email.text.matches(emailPattern.toRegex())) {
            email.error = "Please enter a valid email address"
            isValid = false
        }

        // Check if password is empty or has less than 6 characters
        if (password.text.isNullOrEmpty() || password.text.length < 6) {
            password.error = "Please enter a password with at least 6 characters"
            isValid = false
        }

        // Check if confirm password matches the password
        if (confirmPassword.text.isNullOrEmpty() || confirmPassword.text.toString() != password.text.toString()) {
            confirmPassword.error = "Passwords do not match"
            isValid = false
        }

        return isValid
    }

    fun goToLogin(view: View) {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }

    fun goBackToLogin(view: View){
        if (validateInput()) {
            // Get user's input data
            val userName = username.text.toString()
            val userEmail = email.text.toString()
            val userPassword = password.text.toString()

            // Create a new user object with the input data
            val user = User(userName, userEmail, userPassword, selectedPosition)

            // Get a reference to the Firebase Authentication instance
            val mAuth = FirebaseAuth.getInstance()

            // Create a new user in Firebase Authentication
            mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        // Get a reference to the Firebase Realtime Database instance
                        val database = FirebaseDatabase.getInstance()
                        val ref = database.getReference("User")

                        // Add the new user to the "users" collection in the database
                        ref.child(mAuth.currentUser!!.uid).setValue(user)
                            .addOnSuccessListener {
                                // Show a success message
                                Snackbar.make(view, "User created successfully", Snackbar.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                // Show an error message
                                Snackbar.make(view, "Error creating user: ${it.message}", Snackbar.LENGTH_SHORT).show()
                            }

                        // Sign out the user
                        mAuth.signOut()

                        // Go back to the login activity
                        val intent = Intent(this, ActivityLogin::class.java)
                        intent.putExtra("message", "Signed up Successfully")
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Snackbar.make(view, "Error creating user: ${task.exception?.message}", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }

    fun goToSignup(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
}
