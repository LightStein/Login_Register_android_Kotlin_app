package com.example.sign_up

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*


class profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//        profileName.text = logUser

        Picasso.get().load("http://www.americaspace.com/wp-content/uploads/2012/09/Ed-White-EVA.jpg").placeholder(R.mipmap.placeholder).into(picProfile)


    }
}
