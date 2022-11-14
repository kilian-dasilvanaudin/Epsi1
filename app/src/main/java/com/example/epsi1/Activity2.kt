package com.example.epsi1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Activity2 : AppCompatActivity() {
    val db = Firebase.firestore
    // Create a new user with a first and last name
    val user = hashMapOf(
        "first" to "Test",
        "last" to "Da Silva",
        "born" to 1999
    )
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

/*
        val title = arrayOf("A Realm Reborn","Heavensward","Stormblood","Shadowbringer")
        val imageId = arrayOf("https://img.finalfantasyxiv.com/lds/promo/h/r/l6eq3BOhy145X-sULOMDJFWUmg.png",
            "https://img.finalfantasyxiv.com/lds/promo/h/7/HzOhLvFB0AgVs9BfnEMvO8pRVI.png",
            "https://img.finalfantasyxiv.com/lds/promo/h/n/fs9-H58JXdcSL44DFZimt9-3-8.png",
            "https://img.finalfantasyxiv.com/lds/promo/h/l/Wpxdd7E1zDgSN7d4ITTbSMymfI.png")
        val editor = arrayOf("editor1","editor2","editor3","editor4")
        val releaseDate = arrayOf("27/08/2013","23/06/2015","20/06/2017","02/07/2019")

        val listAdapter = Adapter(this@Activity2, title, imageId, editor, releaseDate)
        val listView = findViewById<ListView>(R.id.list_panel)
        listView.adapter= listAdapter
*/
    }
}