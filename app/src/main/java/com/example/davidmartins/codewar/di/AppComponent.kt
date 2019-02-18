package com.example.davidmartins.codewar.di

import android.app.Application
import com.example.davidmartins.codewar.BaseApplication
import com.example.davidmartins.codewar.di.modules.*
import com.example.davidmartins.codewar.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(modules = [AppModule::class,
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBindindModule::class,
    FragmentBindingModule::class,
    ViewModelModule::class,
    DBModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}