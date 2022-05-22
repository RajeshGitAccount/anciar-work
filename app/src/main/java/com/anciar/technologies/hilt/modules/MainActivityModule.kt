package com.anciar.technologies.hilt.modules

import com.anciar.technologies.AppRepository
import com.anciar.technologies.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainActivityModule {

    @Provides
    fun provideLoginRepository(appRepository:AppRepository): MainRepository = MainRepository(appRepository = appRepository)
}