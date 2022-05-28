package com.anciar.technologies


//return true if email is not valid
fun String.emailValidation(): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z-_]+\\.+[a-z]+"
    return !(this.matches(emailRegex.toRegex()))
}


