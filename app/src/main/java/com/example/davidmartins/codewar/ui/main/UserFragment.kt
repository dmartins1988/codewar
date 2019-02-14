package com.example.davidmartins.codewar.ui.main


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.baseActivity
import com.example.davidmartins.codewar.ui.list.ListActivity
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment() {


    override fun layoutRes(): Int = R.layout.fragment_user


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        click.setOnClickListener { v ->
            startActivity(Intent(baseActivity(), ListActivity::class.java))
        }
    }
}
