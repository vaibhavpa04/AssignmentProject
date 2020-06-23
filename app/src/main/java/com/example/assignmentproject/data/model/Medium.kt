package com.example.assignmentproject.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class Medium (
    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("blogId")
    @Expose
    val blogId: String? = null,

    @SerializedName("createdAt")
    @Expose
    val createdAt: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
)