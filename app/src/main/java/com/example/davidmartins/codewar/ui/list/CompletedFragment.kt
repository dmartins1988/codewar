package com.example.davidmartins.codewar.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.ofFragment

class CompletedFragment : BaseFragment<ListViewModel>() {

    override fun viewModel(): ListViewModel = ofFragment(this, viewModelFactory)

    override fun layoutRes(): Int = R.layout.fragment_completed

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    companion object {
        fun newInstance(): CompletedFragment {
            return CompletedFragment()
        }
    }


}
