package com.example.davidmartins.codewar.di.viewmodel

import com.example.davidmartins.codewar.ui.details.DetailViewModel
import com.example.davidmartins.codewar.ui.list.ListViewModel
import com.example.davidmartins.codewar.ui.main.StartViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubcomponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubcomponent
    }

    fun startViewModel(): StartViewModel

    fun listViewModel(): ListViewModel

    fun detailViewModel(): DetailViewModel
}