package com.example.davidmartins.codewar.ui.main



import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.davidmartins.codewar.Constants

import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.ofFragment
import com.example.davidmartins.codewar.ui.list.ListActivity
import kotlinx.android.synthetic.main.fragment_main.*

class StartFragment : BaseFragment<StartViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_main

    override fun viewModel(): StartViewModel = ofFragment(this, viewModelFactory)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_user.queryHint = "Search for an user ...."
        search_user.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(queryUser: String?): Boolean {
                if (queryUser != null) {
                    viewModel.searchUser(queryUser)
                    observeUserViewModel()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })


        tv_search_user.setOnClickListener {
            val intent = Intent (this@StartFragment.context, ListActivity::class.java)
            intent.putExtra(Constants.BUNDLE_USER_SEARCH, tv_search_user.text)
            startActivity(intent)
        }


    }

    private fun observeUserViewModel() {
        viewModel.getUser().observe(this, Observer {
            if(it != null) {
                if (!it.name.isNullOrEmpty()) {
                    tv_search_user.text = it.name
                } else {
                    tv_search_user.text = it.username
                }
                tv_search_user.visibility = View.VISIBLE
            }
        })

        viewModel.getError().observe(this, Observer {
            if (it != null) if (it) {
                tv_error.visibility = View.VISIBLE
                tv_search_user.visibility = View.GONE
                tv_error.text = "User not found"
            } else {
                tv_error.visibility = View.GONE
                tv_error.text = ""
            }
        })

        viewModel.getLoading().observe(this, Observer {
            if (it != null) if (it) {
                loading_view.visibility = View.VISIBLE
            } else {
                loading_view.visibility = View.GONE
            }
        })
    }

    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }

}
