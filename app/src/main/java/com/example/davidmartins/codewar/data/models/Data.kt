package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("completedAt")
        val completedAt: String,
        @SerializedName("completedLanguages")
        val completedLanguages: List<String>,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("slug")
        val slug: String
)