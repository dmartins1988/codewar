package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("clan")
        val clan: String,
        @SerializedName("codeChallenges")
        val codeChallenges: CodeChallenges,
        @SerializedName("honor")
        val honor: Int,
        @SerializedName("leaderboardPosition")
        val leaderboardPosition: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("ranks")
        val ranks: Ranks,
        @SerializedName("skills")
        val skills: List<String>,
        @SerializedName("username")
        val username: String
)