package com.anciar.technologies.hilt.modules

import com.anciar.technologies.AppRepository
import com.anciar.technologies.login.LoginRespository
import com.anciar.technologies.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class LoginAtivityModule {

    @Provides
    fun provideLoginRepository(appRepository:AppRepository): LoginRespository = LoginRespository(appRepository = appRepository)
}