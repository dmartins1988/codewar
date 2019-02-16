package com.example.davidmartins.codewar.ui.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseActivity

class StartActivity : BaseActivity() {

    lateinit var toolbar: Toolbar

    override fun layoutRes(): Int = R.layout.activity_start

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Main"
        }

    }
}
