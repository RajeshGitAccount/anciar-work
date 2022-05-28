package com.anciar.technologies.main.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModelItem(
    @SerializedName("email")
    @Expose(serialize = true,deserialize = true)
    var email: String?,
    @SerializedName("gender")
    @Expose(serialize = true,deserialize = true)
    var gender: String?,
    @SerializedName("id")
    @Expose(serialize = true,deserialize = true)
    var id: Int?,
    @SerializedName("name")
    @Expose(serialize = true,deserialize = true)
    var name: String?,
    @SerializedName("status")
    @Expose(serialize = true,deserialize = true)
    var status: String?
)