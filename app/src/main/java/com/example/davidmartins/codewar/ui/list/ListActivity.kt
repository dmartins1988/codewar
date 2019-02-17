package com.example.davidmartins.codewar.ui.list

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseActivity
import com.example.davidmartins.codewar.replaceFragment
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    lateinit var toolbar: Toolbar

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_completed_challenges -> {
                setToolbar("Completed Challenges")
                replaceFragment(CompletedFragment.newInstance(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_authored_challenges -> {
                setToolbar("Authored Challenges")
                replaceFragment(AuthoredFragment.newInstance(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setToolbar("Completed Challenges")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

    private fun setToolbar(title: String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }


}
