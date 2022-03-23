package com.example.service_cat.data.model

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("categories")
    val category: List<Category>?,
    @SerializedName("breeds")
    val breed: List<Breed>?,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url_picture: String)