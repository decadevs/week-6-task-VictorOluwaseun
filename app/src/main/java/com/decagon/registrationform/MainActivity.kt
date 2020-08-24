package com.decagon.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister.setOnClickListener{
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNum.text.toString()

            Intent(this, ProfileActivity::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_EMAIL", email)
                it.putExtra("EXTRA_PHONE_NUMBER", phoneNumber)
                 startActivity(it) //Instead of Intent instance
            }
        }

    }
}