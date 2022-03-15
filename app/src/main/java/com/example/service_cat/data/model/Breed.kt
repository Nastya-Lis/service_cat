package com.example.service_cat.data.model

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("wikipedia_url")
    val wikipedia_url: String,
    @SerializedName("hairless")
    val hairless: Int,
    @SerializedName("child_friendly")
    val child_friendly: Int,
    @SerializedName("dog_friendly")
    val dog_friendly: Int,
    @SerializedName("strange_friendly")
    val strange_friendly: Int,
    @SerializedName("health_issues")
    val health_issues: Int,
    @SerializedName("social_needs")
    val social_needs: Int
) {
}