package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Languages(
        @SerializedName("coffeescript")
        val coffeescript: Coffeescript,
        @SerializedName("javascript")
        val javascript: Javascript,
        @SerializedName("ruby")
        val ruby: Ruby
)