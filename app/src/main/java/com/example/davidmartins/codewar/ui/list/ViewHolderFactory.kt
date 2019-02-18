package com.example.davidmartins.codewar.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.davidmartins.codewar.R
import com.example.davidmartins.codewar.data.models.Authored
import com.example.davidmartins.codewar.data.models.Completed

object ViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.complete_challenge_list_item -> CompleteChallengeVH(view)
            R.layout.authored_challenge_list_item -> AuthoredChallengeVH(view)
            else -> {
                CompleteChallengeVH(view)
            }
        }
    }

    class CompleteChallengeVH(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Completed> {

        var completeName: TextView = itemView.findViewById(R.id.tv_completed_name)
        var completeDate: TextView = itemView.findViewById(R.id.tv_completed_date)

        override fun bind(data: Completed, listener: GenericAdapter.OnItemClickListener) {
            completeName.text = data.name
            completeDate.text = data.completedAt
            listener.onClickChallenged(data.id)
        }

    }

    class AuthoredChallengeVH(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Authored> {

        var authoredName: TextView = itemView.findViewById(R.id.tv_authored_name)
        var authoredDescription: TextView = itemView.findViewById(R.id.tv_authored_description)
        var authoredRank: TextView = itemView.findViewById(R.id.tv_authored_rank)
        var authoredLanguages: TextView = itemView.findViewById(R.id.tv_authored_languages)

        override fun bind(data: Authored, listener: GenericAdapter.OnItemClickListener) {
            authoredName.text = data.name
            authoredDescription.text = data.description
            authoredRank.text = data.rank.toString()
            authoredLanguages.text = data.languages.joinToString()
            listener.onClickChallenged(data.id)
        }
    }
}