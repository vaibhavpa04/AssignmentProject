package com.example.assignmentproject.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class ResponseHandler (
    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("createdAt")
    @Expose
    val createdAt: String? = null,

    @SerializedName("content")
    @Expose
    val content: String? = null,

    @SerializedName("comments")
    @Expose
    val comments: Int? = null,

    @SerializedName("likes")
    @Expose
    val likes: Int? = null,

    @SerializedName("media")
    @Expose
    val media: List<Medium>? = null,

    @SerializedName("user")
    @Expose
    val user: List<User>? = null
)