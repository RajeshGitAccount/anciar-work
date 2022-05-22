package com.anciar.technologies.hilt.modules

import com.anciar.technologies.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun getAppRepository():AppRepository = AppRepository()
}