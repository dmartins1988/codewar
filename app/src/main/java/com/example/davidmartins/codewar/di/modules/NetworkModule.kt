package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.BuildConfig
import com.example.davidmartins.codewar.data.api.CodeWarApi
import com.example.davidmartins.codewar.data.interceptor.CustomInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private val BASE_URL = "https://www.codewars.com/api/v1/"

    @Provides
    @Singleton
    fun provideApiInterceptor() = CustomInterceptor(BuildConfig.API_KEY)

    @Provides
    @Singleton
    fun provideLoggingInterceptor() :HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                            customInterceptor: CustomInterceptor) : OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addInterceptor(customInterceptor)
                    .build()

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient) : Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    @Singleton
    fun providesCodeWarApi(retrofit: Retrofit) : CodeWarApi {
        return retrofit.create(CodeWarApi::class.java)
    }
}