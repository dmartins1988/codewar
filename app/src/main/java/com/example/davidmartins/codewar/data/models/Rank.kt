package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Rank(
        @SerializedName("color")
        val color: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)