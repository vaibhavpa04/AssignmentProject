package com.example.assignmentproject.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("blogId")
    @Expose
    val blogId: String? = null,

    @SerializedName("createdAt")
    @Expose
    val createdAt: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("avatar")
    @Expose
    val avatar: String? = null,

    @SerializedName("lastname")
    @Expose
    val lastname: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null,

    @SerializedName("designation")
    @Expose
    val designation: String? = null,

    @SerializedName("about")
    @Expose
    val about: String? = null
)