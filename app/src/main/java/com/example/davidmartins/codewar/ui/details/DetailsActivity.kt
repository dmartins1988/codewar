package com.example.davidmartins.codewar.ui.details

import android.os.Bundle
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseActivity

class DetailsActivity : BaseActivity() {

    override fun layoutRes(): Int = R.layout.activity_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }
}
