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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ActivitySignUp: AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var positionSupervisor: RadioButton
    private lateinit var positionParent: RadioButton
    private var selectedPosition = ""
    private lateinit var database: FirebaseDatabase
    private lateinit var usersRef: DatabaseReference
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        usersRef = database.getReference("User")
        firstName = findViewById(R.id.myUserName)
        lastName = findViewById(R.id.myLastName)
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

        // Check if first name is empty
        if (firstName.text.isNullOrEmpty()) {
            firstName.error = "Please enter your first name"
            isValid = false
        }

        // Check if last name is empty
        if (lastName.text.isNullOrEmpty()) {
            lastName.error = "Please enter your last name"
            isValid = false
        }

        // Check if email is empty or invalid
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (email.text.isNullOrEmpty() || !email.text.matches(emailPattern.toRegex())) {
            email.error = "Please enter a valid email address"
            isValid = false
        } else {
            // Check if email is unique
            usersRef.orderByChild("email").equalTo(email.text.toString()).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        email.error = "Email address is already in use"
                        isValid = false
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Firebase", "Error checking if email is unique: ${error.message}")
                }
            })
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
            val firstName = firstName.text.toString()
            val lastName = lastName.text.toString()
            val userEmail = email.text.toString()
            val userPassword = password.text.toString()

            // Create a new user object with the input data
            val user = User(firstName, lastName, userEmail, userPassword, selectedPosition)

            // Check if email is already taken
            val query: Query = usersRef.orderByChild("email").equalTo(userEmail)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Show an error message if email is already taken
                        Snackbar.make(view, "Email address is already taken", Snackbar.LENGTH_SHORT).show()
                    } else {
                        // Create a new user in Firebase Authentication
                        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                            .addOnCompleteListener(this@ActivitySignUp) { task ->
                                if (task.isSuccessful) {
                                    // Add the new user to the "users" collection in the database
                                    usersRef.child(auth.currentUser!!.uid).setValue(user)
                                        .addOnSuccessListener {
                                            // Show a success message
                                            Snackbar.make(view, "User created successfully", Snackbar.LENGTH_SHORT)
                                                .setDuration(1000).show()

                                        }
                                        .addOnFailureListener {
                                            // Show an error message
                                            Snackbar.make(view, "Error creating user: ${it.message}", Snackbar.LENGTH_SHORT).show()
                                        }

                                    // Go back to the login activity
                                    val intent = Intent(this@ActivitySignUp, ActivityLogin::class.java)
                                    intent.putExtra("message", "Signed up Successfully")
                                    startActivity(intent)

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Snackbar.make(view, "Error creating user: ${task.exception?.message}", Snackbar.LENGTH_SHORT).show()
                                }
                            }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Show an error message if there is an error reading data from the database
                    Snackbar.make(view, "Error reading data from database: ${databaseError.message}", Snackbar.LENGTH_SHORT).show()
                }
            })
        }
    }


    fun goToSignup(view: View) {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
}
