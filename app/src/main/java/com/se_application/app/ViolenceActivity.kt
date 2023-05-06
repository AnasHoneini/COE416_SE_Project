package com.se_application.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ViolenceActivity : AppCompatActivity(){

    private lateinit var dbref: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var violArraylist: ArrayList<ViolenceData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.violencerecyclerview)

        recyclerView = findViewById(R.id.userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        violArraylist = arrayListOf<ViolenceData>()
        getUserData()
    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("ViolenceData")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                violArraylist.clear()
                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){

                        val user = userSnapshot.getValue(ViolenceData::class.java)
                        violArraylist.add(user!!)

                    }

                    recyclerView.adapter = ViolenceAdapter(violArraylist)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}