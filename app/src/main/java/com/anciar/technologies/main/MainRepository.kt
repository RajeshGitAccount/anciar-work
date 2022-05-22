package com.anciar.technologies.main

import com.anciar.technologies.AppRepository
import com.anciar.technologies.main.model.SectionsModel
import javax.inject.Inject

class MainRepository @Inject constructor(val appRepository: AppRepository) {
    fun getRecyclerData(): ArrayList<SectionsModel> = appRepository.getRequiredInfo()
}