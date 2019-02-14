package com.example.davidmartins.codewar.ui.list

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    lateinit var toolbar: ActionBar

    override fun layoutRes(): Int {
        return R.layout.activity_list
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_completed_challenges -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_authored_challenges -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
