package com.decagon.registrationform

import android.widget.EditText

class PhoneNumberValidation {
    companion object {
        operator fun invoke(vararg allEdits: EditText): EditText? {

            for (view in allEdits) {
                if (view.text.isEmpty()) {
                    return view
                }
            }
            return null
        }

        /**
         * The input is not valid if..
         * ...The name || username || password || phone contact is empty
         * ...The user phone number does not start with 234 || +234 || 0
         * ...The user phone number is less than 11 or greater than 13
         * .. The name and password contains less than 2 digits
         *
         *
         */

        fun validatePhoneNumber(userPhone: String) : Boolean {
            if (userPhone.startsWith("0") && !userPhone.startsWith("234")) {
                userPhone.removePrefix("0")
                userPhone.commonPrefixWith("+234")
                return true
            }
            return false

        }
        fun validateNameLength (name : String, username : String) : Boolean {
            if (name.count { it.isDigit() } < 3 && username.count { it.isDigit() } < 2) {
                return false
            }
            return true
        }

        fun validateContactLength (contact : String) : Boolean {
            if (contact.count { it.isDigit() } < 11 && contact.count { it.isDigit() } > 13) {
                return false
            }
            return true
        }

        fun fieldsEmpty (name : String, username: String, phone : String, password : String) : Boolean {
            if (name.isEmpty() || username.isEmpty() || phone.isEmpty() || password.isEmpty()) {

                return false
            }
            return true
        }

        fun notStartWithCountryCode(contact: String): Boolean {

            if (!contact.startsWith("234") || !contact.startsWith("0") || !contact.startsWith("+234")) {
                return false
            }
            return true

        }

        fun specialFieldValidation (contact : String?, email : String?, password: String?) : String? {

            val contactValidator = Regex("^(\\+?234|0)[897][01]\\d{8}${'$'}")
            val emailValidator = Regex("^[A-Za-z0-9+_.-]+@(.+)$")
            val passwordValidator = Regex("""^[a-zA-Z0-9@$!._%*#?&]{6,}$""")
            var message: String? = ""

            when {
                contact != null && email != null && password != null -> {
                    val contactMatched = contactValidator.matches(contact)
                    val emailMatched = emailValidator.matches(email)
                    val passwordMatched = passwordValidator.matches(password)

                    message = when {
                        !contactMatched -> contact
                        !emailMatched -> email
                        !passwordMatched -> password
                        else -> null
                    }
                }

                contact != null -> {
                    val contactMatched = contactValidator.matches(contact.toString())
                    message = when {
                        !contactMatched -> email
                        else -> null
                    }
                }

                email != null -> {
                    val emailMatched = emailValidator.matches(email.toString())
                    message = when {
                        !emailMatched -> email
                        else -> null
                    }
                }

                password != null -> {
                    val passwordMatched = passwordValidator.matches(password.toString())
                    message = when {
                        !passwordMatched -> email
                        else -> null
                    }
                }

            }

            return message
        }