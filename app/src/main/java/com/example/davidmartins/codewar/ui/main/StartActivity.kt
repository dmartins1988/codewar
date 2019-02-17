package com.example.davidmartins.codewar.ui.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.addFragment
import com.example.davidmartins.codewar.base.BaseActivity

class StartActivity : BaseActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setToolbar()

        addFragment(StartFragment.newInstance(), R.id.container)


    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Main"
        }
    }
}
