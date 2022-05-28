package com.anciar.technologies.login.model

import com.google.gson.annotations.SerializedName

open class LoginRequestModel(
    @SerializedName("email") var email: String?=null,
    @SerializedName("password") var pswd: String?=null
)
