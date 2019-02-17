package com.example.davidmartins.codewar.di.modules

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.example.davidmartins.codewar.di.viewmodel.ViewModelSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
        subcomponents = [
            ViewModelSubcomponent::class
        ]
)
class AppModule {

    @Provides
    @Singleton
    fun applicationContext(app: Application): Context = app

    @Provides
    fun glide(context: Context) = Glide.with(context)

}