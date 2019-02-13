package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Completed(
        @SerializedName("data")
        val data: List<Data>,
        @SerializedName("totalItems")
        val totalItems: Int,
        @SerializedName("totalPages")
        val totalPages: Int
)