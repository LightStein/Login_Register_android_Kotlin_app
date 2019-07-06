package com.example.sign_up

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_register.*

class signup_activity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()


        signupButton.setOnClickListener {

            if (regUsername.text.toString().isEmpty() || regEmail.text.toString().isEmpty() ||
                    regPassword.text.toString().isEmpty() || regCheckPassword.text.toString().isEmpty())
                Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_LONG).show()
            else if (!(regPassword.text.toString()?.equals(regCheckPassword.text.toString())))
                Toast.makeText(applicationContext, "Passwords doesn't match, Please Double-check", Toast.LENGTH_LONG).show()
            else {
                auth.createUserWithEmailAndPassword(regEmail.text.toString(), regPassword.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Email", "createUserWithEmail:success")
                                val user = auth.currentUser
                                Toast.makeText(this, "you have signed up successfully", Toast.LENGTH_SHORT).show()

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Fail", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }
    }

}
