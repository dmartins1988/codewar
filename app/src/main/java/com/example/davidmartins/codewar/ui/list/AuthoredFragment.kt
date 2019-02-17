package com.example.davidmartins.codewar.ui.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.ofFragment


class AuthoredFragment : BaseFragment<ListViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_challenge_authored

    override fun viewModel(): ListViewModel = ofFragment(this, viewModelFactory)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    companion object {
        fun newInstance(): AuthoredFragment {
            return AuthoredFragment()
        }
    }
}
