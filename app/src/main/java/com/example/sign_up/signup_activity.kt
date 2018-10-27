package com.example.sign_up

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_register.*

class signup_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        signupButton.setOnClickListener {

            if(regUsername.text.toString().isEmpty() || regEmail.text.toString().isEmpty() ||
                    regPassword.text.toString().isEmpty() || regCheckPassword.text.toString().isEmpty())
                Toast.makeText(applicationContext,"Please fill all the fields", Toast.LENGTH_LONG).show()
            else if (!(regEmail.text.toString() != null && android.util.Patterns.EMAIL_ADDRESS.matcher(regEmail.text.toString()).matches()))
                Toast.makeText(applicationContext,"Invalid E-mail, Please Check",Toast.LENGTH_LONG).show()
            else if (!(regPassword.text.toString()?.equals(regCheckPassword.text.toString())))
                Toast.makeText(applicationContext,"Passwords doesn't match, Please Double-check",Toast.LENGTH_LONG).show()
            else Toast.makeText(applicationContext,"You've signed up successfully",Toast.LENGTH_LONG).show()





        }
    }

}
