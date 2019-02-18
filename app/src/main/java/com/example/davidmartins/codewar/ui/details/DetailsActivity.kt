package com.example.davidmartins.codewar.ui.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.addFragment
import com.example.davidmartins.codewar.base.BaseActivity

class DetailsActivity : BaseActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setToolbar()

        addFragment(DetailFragment.newInstance(), R.id.container)
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Main"
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
