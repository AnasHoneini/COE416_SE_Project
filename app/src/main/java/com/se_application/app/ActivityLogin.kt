package com.se_application.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.se_application.app.databinding.ActivityLoginPageBinding


class ActivityLogin : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var forgetPass: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var usersRef: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        usersRef = database.getReference("User")
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

        if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
            checkUserExistsInFirebase(inputEmail, inputPassword, view)
        } else {
            Snackbar.make(view, "Please enter your email and password", Snackbar.LENGTH_SHORT).show()
        }
    }




    private fun checkUserExistsInFirebase(email: String, password: String, view: View) {
        val query: Query = usersRef.orderByChild("email").equalTo(email)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user: User? = null
                for (childSnapshot in dataSnapshot.children) {
                    val tempUser = childSnapshot.getValue(User::class.java)
                    if (tempUser != null && tempUser.password == password) {
                        user = tempUser
                        break
                    }
                }
                if (user != null) {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val position = user.position
                                Log.d("pos",position)
                                val intent = when (position) {
                                    "Supervisor" -> Intent(this@ActivityLogin, ActivityDashboard::class.java)
                                    "Parent" -> Intent(this@ActivityLogin, ActivityParentDashboard::class.java)
                                    else -> null
                                }
                                if (intent != null) {
                                    val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                                    val editor = sharedPref.edit()
                                    editor.putString("username", user.username)
                                    editor.apply()
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Snackbar.make(view, "Invalid position", Snackbar.LENGTH_SHORT).show()
                                }
                            } else {
                                Snackbar.make(view, "Error signing in: ${task.exception?.message}", Snackbar.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Snackbar.make(view, "Invalid email or password", Snackbar.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Firebase", "Error reading data from database: ${databaseError.message}")
                Snackbar.make(view, "Error reading data from database: ${databaseError.message}", Snackbar.LENGTH_SHORT).show()
            }
        })
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