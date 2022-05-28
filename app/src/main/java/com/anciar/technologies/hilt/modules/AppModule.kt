package com.anciar.technologies.hilt.modules

import android.content.Context
import com.anciar.technologies.AppRepository
import com.anciar.technologies.network.ApiService
import com.anciar.technologies.network.NetworkConnectionInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    val BASE_URL = "https://gorest.co.in/public/v2/"



    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor()= HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    @Provides
    @Singleton
    fun providesHttpLogginInterceptor(httpLogginInterceptor: HttpLoggingInterceptor, @ApplicationContext appContext: Context): OkHttpClient =
//        if(BuildConfig.IS_RELEASE_BUILD) {
        OkHttpClient.Builder()
            .addInterceptor(httpLogginInterceptor)
            .addInterceptor(NetworkConnectionInterceptor(appContext))
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRepository(apiService:ApiService) : AppRepository = AppRepository(apiService)

}