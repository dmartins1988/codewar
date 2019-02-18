package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Authored(
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("languages")
        val languages: List<String>,
        @SerializedName("name")
        val name: String,
        @SerializedName("rank")
        val rank: Int,
        @SerializedName("rankName")
        val rankName: String,
        @SerializedName("tags")
        val tags: List<String>
)