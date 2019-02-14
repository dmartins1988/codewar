package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.ui.details.DetailsActivity
import com.example.davidmartins.codewar.ui.list.ListActivity
import com.example.davidmartins.codewar.ui.list.ListFragmentBindingModule
import com.example.davidmartins.codewar.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ListFragmentBindingModule::class])
    internal abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector
    internal abstract fun bindDetailsActivity(): DetailsActivity

}