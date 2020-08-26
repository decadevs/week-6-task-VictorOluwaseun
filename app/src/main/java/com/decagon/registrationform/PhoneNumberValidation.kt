package com.decagon.registrationform

import android.util.Log
import android.widget.EditText

class PhoneNumberValidation {

    fun validation(phone: String, name:String, email:String, gender: String): Boolean{
        var regexPhone = "(^[0]\\d{10}\$)|(^[\\+]?[234]\\d{12}\$)".toRegex()
        var regexName = "[a-zA-Z]+".toRegex()
        var regexEmail = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$)".toRegex()

         var  isPhone = phone.matches(regexPhone)
       var  isEmail = email.matches(regexEmail)
        var isName = name.replace(" ", "").matches(regexName)

        var isGender = gender.equals("Male") || gender.equals("Female") || gender.equals("Prefer not to say")

        return isEmail && isName && isGender && isPhone
    }
}