package com.example.davidmartins.codewar.di

import com.example.davidmartins.codewar.base.BaseApplication
import com.example.davidmartins.codewar.di.modules.ActivityBindingModule
import com.example.davidmartins.codewar.di.modules.NetworkModule
import com.example.davidmartins.codewar.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBindingModule::class, ViewModelModule::class])
@Singleton
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}