package com.example.sign_up

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginButton.setOnClickListener {

            if(logEmail.text.toString().isEmpty() || logPassword.text.toString().isEmpty())
                Toast.makeText(applicationContext,"Please fill all the fields",Toast.LENGTH_LONG).show()
            else if (!(logEmail.text.toString() != null && android.util.Patterns.EMAIL_ADDRESS.matcher(logEmail.text.toString()).matches()))
                Toast.makeText(applicationContext,"Invalid E-mail, Please Check",Toast.LENGTH_LONG).show()
            else Toast.makeText(applicationContext,"You've signed in successfully",Toast.LENGTH_LONG).show()
        }
        notSignedUp.setOnClickListener{
            val intent = Intent(this,signup_activity::class.java)
            startActivity(intent)
        }


    }

}
