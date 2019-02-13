package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class CodeChallenges(
        @SerializedName("totalAuthored")
        val totalAuthored: Int,
        @SerializedName("totalCompleted")
        val totalCompleted: Int
)