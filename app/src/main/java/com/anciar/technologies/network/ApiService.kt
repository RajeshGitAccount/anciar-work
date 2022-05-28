package com.anciar.technologies.network

import com.anciar.technologies.main.model.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @GET("users")
    suspend fun getUserInfo():UserModel
}