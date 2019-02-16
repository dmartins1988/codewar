package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class CreatedBy(
        @SerializedName("url")
        val url: String,
        @SerializedName("username")
        val username: String
)