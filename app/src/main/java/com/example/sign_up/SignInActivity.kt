package com.example.sign_up

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*
class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {

            if(logEmail.text.toString().isEmpty() || logPassword.text.toString().isEmpty())
                Toast.makeText(applicationContext,"Please fill all the fields",Toast.LENGTH_LONG).show()
            else{

                auth.signInWithEmailAndPassword(logEmail.text.toString(), logPassword.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Email", "signInWithEmail:success")
                                val user = auth.currentUser
                                val intent = Intent(this,profile::class.java)
                                startActivity(intent)

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Fail", "signInWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }
        notSignedUp.setOnClickListener{
            val intent = Intent(this,signup_activity::class.java)
            startActivity(intent)
        }
    }
}
