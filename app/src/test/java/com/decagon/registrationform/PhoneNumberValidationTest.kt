package com.decagon.registrationform

import org.junit.Test

import org.junit.Assert.*

class PhoneNumberValidationTest {

    val NAME = "Adewumi Victor"
    val PHONE_NUMBER = "07032333653"
    val GENDER = "Male"
    val EMAIL = "adevic4christ@gmail.com"
    val validator = PhoneNumberValidation()

//    fun validation(phone: String, name:String, email:String, gender: String): Boolean{

        @Test
    fun validationTest() {
        assertTrue(validator.validation(PHONE_NUMBER, NAME, EMAIL, GENDER))
    }
}