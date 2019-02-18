package com.example.davidmartins.codewar.ui.list

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import com.example.davidmartins.codewar.Constants
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseActivity
import com.example.davidmartins.codewar.replaceFragment
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    lateinit var toolbar: Toolbar
    lateinit var userName: String

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_completed_challenges -> {
                setToolbar("CompletedResponse Challenges")
                replaceFragment(
                        CompletedFragment.newInstance(userName),
                        R.id.container
                )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_authored_challenges -> {
                setToolbar("AuthoredResponse Challenges")
                replaceFragment(
                        AuthoredFragment.newInstance(userName),
                        R.id.container
                )
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setToolbar("CompletedResponse Challenges")
        getUserName()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun getUserName() {
        userName = intent.getStringExtra(Constants.BUNDLE_USER_SEARCH)
    }

    private fun setToolbar(title: String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
