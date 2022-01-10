package com.example.uas19090133.model

import com.google.gson.annotations.SerializedName

data class RPost (
//    val userId: Int,
//    val id: Int,
//    val title: String,
//    val body: String
        val userId: Int,
        val id: Int,
        val title: String?,
        @SerializedName("body")
        val text: String?
    )