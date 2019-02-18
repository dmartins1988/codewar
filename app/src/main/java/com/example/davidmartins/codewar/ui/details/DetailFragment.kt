package com.example.davidmartins.codewar.ui.details

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidmartins.codewar.Constants

import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.ofFragment
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : BaseFragment<DetailViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_detail

    override fun viewModel(): DetailViewModel = ofFragment(this, viewModelFactory)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetailsViewModel()
    }

    private fun observeDetailsViewModel() {
        viewModel.getDetail(getDetailIdArgument()!!)
        viewModel.getDetails().observe(this, Observer {
            if (it != null) {
                tv_detail_name.text = it.name
                tv_detail_description.text = it.description
                tv_publish_date.text = it.publishedAt
                tv_approved_date.text = it.approvedAt
                tv_approved_by.text = it.approvedBy.username
                tv_total_attempts.text = it.totalAttempts.toString()
                tv_total_completed.text = it.totalCompleted.toString()
                tv_total_stars.text = it.totalStars.toString()

            }
        })

        viewModel.getError().observe(this, Observer {
            if (it != null) if (it) {
                tv_detail_error.visibility = View.VISIBLE
                tv_detail_error.text = "Details not found"
            } else {
                tv_detail_error.visibility = View.GONE
            }
        })

        viewModel.getLoading().observe(this, Observer {
            if (it != null) if (it) {
                detail_loading_view.visibility = View.VISIBLE
            } else {
                detail_loading_view.visibility = View.GONE
            }
        })


    }

    companion object {
        fun newInstance(): DetailFragment{
            return DetailFragment()
        }

        fun newInstance(id: String) : DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(Constants.BUNDLE_CHALLENGED_ID, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    private fun getDetailIdArgument() = arguments?.getString(Constants.BUNDLE_CHALLENGED_ID)

}
