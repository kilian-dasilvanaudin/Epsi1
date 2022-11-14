package com.example.epsi1

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {

    // Add a new document with a generated ID

    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            val i = Intent(this, Adapter::class.java)
            startActivity(i)

        }
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        auth = FirebaseAuth.getInstance()


        val db = Firebase.firestore
        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Test",
            "last" to "Connexion",
            "born" to 200
        )
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                Toast.makeText(this, "Success DB", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                Toast.makeText(this, "Error DB", Toast.LENGTH_LONG).show()
            }

        val tv = findViewById<TextView>(R.id.tv_title)

        tv.setOnClickListener {
            (it as TextView).apply {
                text = "Easter egg?"
                setTextColor(Color.GREEN)
                setBackgroundColor(Color.RED)
            }
        }

        findViewById<Button>(R.id.boutonConnexion).setOnTouchListener { view, motionEvent ->
            if (motionEvent.action === MotionEvent.ACTION_DOWN){
                view.apply {
                    setBackgroundColor(Color.RED)
                }
            }
            if (motionEvent.action === MotionEvent.ACTION_UP)
                view.apply {
                    setBackgroundColor(Color.MAGENTA)
                    handleConnection()
            }

            return@setOnTouchListener true
        }
     }


    fun handleConnection(){
        val v_username = findViewById<EditText>(R.id.valueUsername)
        val v_password = findViewById<EditText>(R.id.valuePassword)

        var username = v_username.text
        var password = v_password.text
        if(username.isEmpty() and password.isEmpty()){
            Toast.makeText(this, getString(R.string.errorConnexion), Toast.LENGTH_LONG).show()
            return
        }
        auth.signInWithEmailAndPassword(username.toString(), password.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val i = Intent(this, Adapter::class.java)
                    startActivity(i)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }

    }

