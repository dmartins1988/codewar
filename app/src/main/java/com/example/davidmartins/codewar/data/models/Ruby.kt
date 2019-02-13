package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Ruby(
        @SerializedName("color")
        val color: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("rank")
        val rank: Int,
        @SerializedName("score")
        val score: Int
)