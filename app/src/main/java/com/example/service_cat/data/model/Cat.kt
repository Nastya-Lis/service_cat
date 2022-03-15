package com.example.service_cat.data.model

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("category")
    val category: Category?,
    @SerializedName("breed")
    val breed: Breed,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url_picture: String) {

}