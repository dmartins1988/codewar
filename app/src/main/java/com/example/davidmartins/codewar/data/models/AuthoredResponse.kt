package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class AuthoredResponse(
        @SerializedName("data")
        val data: List<Authored>
)