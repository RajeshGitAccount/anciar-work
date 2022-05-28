package com.anciar.technologies.main

import com.anciar.technologies.AppRepository
import com.anciar.technologies.main.model.SectionsModel
import com.anciar.technologies.main.model.UserModel
import javax.inject.Inject

class MainRepository @Inject constructor(val appRepository: AppRepository) {


    suspend fun getRecyclerData(): UserModel = appRepository.getuserData()

}