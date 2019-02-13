package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Authored(
        @SerializedName("data")
        val data: List<DataX>
)