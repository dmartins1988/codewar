package com.example.davidmartins.codewar.ui.list

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidmartins.codewar.Constants
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.base.BaseFragment
import com.example.davidmartins.codewar.data.models.Completed
import com.example.davidmartins.codewar.ofFragment
import com.example.davidmartins.codewar.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.fragment_main.*

class CompletedFragment : BaseFragment<ListViewModel>(), GenericAdapter.OnItemClickListener{

    override fun onClickChallenged(id: String) {
        val intent = Intent (this@CompletedFragment.context, DetailsActivity::class.java)
        intent.putExtra(Constants.BUNDLE_CHALLENGED_ID, id)
        startActivity(intent)
    }

    lateinit var recyclerView: RecyclerView

    override fun viewModel(): ListViewModel = ofFragment(this, viewModelFactory)

    override fun layoutRes(): Int = R.layout.fragment_completed

    private val adapter by lazy {
        object : GenericAdapter<Completed>(this) {
            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder = ViewHolderFactory.create(view, viewType)

            override fun getLayoutId(position: Int, obj: Completed): Int = R.layout.complete_challenge_list_item
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeListOfCompleted()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

    }

    private fun observeListOfCompleted() {
        viewModel.getCompletedChallenges(getUserNameArgument()!!)
        viewModel.getCompletedChallenge().observe(this, Observer {
            tv_error.visibility = View.VISIBLE
            tv_error.text = it.toString()
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
        fun newInstance(): CompletedFragment {
            return CompletedFragment()
        }

        fun newInstance(userName: String): CompletedFragment {
            val fragment = CompletedFragment()
            val bundle = Bundle()
            bundle.putString(Constants.BUNDLE_USER_SEARCH, userName)
            fragment.arguments = bundle
            return fragment
        }
    }


    private fun getUserNameArgument(): String? = arguments?.getString(Constants.BUNDLE_USER_SEARCH)
}
