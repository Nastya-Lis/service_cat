package com.example.service_cat.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Number,
    @SerializedName("name")
    val name: String) {
}