package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Detail(
        @SerializedName("approvedAt")
        val approvedAt: String,
        @SerializedName("approvedBy")
        val approvedBy: ApprovedBy,
        @SerializedName("category")
        val category: String,
        @SerializedName("createdBy")
        val createdBy: CreatedBy,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("languages")
        val languages: List<String>,
        @SerializedName("name")
        val name: String,
        @SerializedName("publishedAt")
        val publishedAt: String,
        @SerializedName("rank")
        val rank: Rank,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("tags")
        val tags: List<String>,
        @SerializedName("totalAttempts")
        val totalAttempts: Int,
        @SerializedName("totalCompleted")
        val totalCompleted: Int,
        @SerializedName("totalStars")
        val totalStars: Int,
        @SerializedName("url")
        val url: String
)