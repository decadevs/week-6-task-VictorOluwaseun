package com.decagon.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = intent.getStringExtra("EXTRA_NAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phoneNo = intent.getStringExtra("EXTRA_PHONE_NUMBER")
        val gender = intent.getStringExtra("EXTRA_GENDER")

        tvProfileName.text = name
        tvProfileEmail.text = email
        tvProfilePhoneNo.text = phoneNo
        tvGender.text = gender

        btnBack.setOnClickListener{
            finish()
        }

    }
}