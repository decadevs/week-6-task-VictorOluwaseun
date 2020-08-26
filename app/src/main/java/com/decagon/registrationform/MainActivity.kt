package com.decagon.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val phoneNumberValidator = PhoneNumberValidation()
        btnRegister.setOnClickListener{
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNum.text.toString()
            val gender = spGender.selectedItem.toString()


            var isValid = phoneNumberValidator.validation(phoneNumber, name, email, gender)

            if (isValid) {
                Intent(this, ProfileActivity::class.java).also {
                    it.putExtra("EXTRA_NAME", name)
                    it.putExtra("EXTRA_EMAIL", email)
                    it.putExtra("EXTRA_PHONE_NUMBER", phoneNumber)
                    it.putExtra("EXTRA_GENDER", gender)
                    startActivity(it) //Instead of Intent instance
                }
            } else{
                Toast.makeText(this, "Check Your inputs again please", Toast.LENGTH_LONG).show()
            }
        }

    }
}