package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.ui.list.ListActivity
import com.example.davidmartins.codewar.ui.list.ListFragmentBindingModule
import com.example.davidmartins.codewar.ui.main.MainActivity
import com.example.davidmartins.codewar.ui.main.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ListFragmentBindingModule::class])
    internal abstract fun bindListActivity(): ListActivity

}