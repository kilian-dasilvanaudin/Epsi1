package com.example.epsi1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class Adapter : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.boutonLogout).setOnTouchListener { view, motionEvent ->
            if (motionEvent.action === MotionEvent.ACTION_DOWN){
                view.apply {
                    setBackgroundColor(Color.RED)
                }
            }
            if (motionEvent.action === MotionEvent.ACTION_UP)
                view.apply {
                    setBackgroundColor(Color.MAGENTA)
                    handleLogout()
                }

            return@setOnTouchListener true
        }


    }

    fun handleLogout(){
        auth.signOut()
        Toast.makeText(baseContext, "Logged out",
            Toast.LENGTH_SHORT).show()
        val i = Intent(this@Adapter, MainActivity::class.java)
        startActivity(i)
    }
}