package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class CompletedResponse(
        @SerializedName("data")
        val data: List<Completed>,
        @SerializedName("totalItems")
        val totalItems: Int,
        @SerializedName("totalPages")
        val totalPages: Int
)