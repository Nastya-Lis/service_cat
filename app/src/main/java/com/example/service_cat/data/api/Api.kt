package com.example.service_cat.data.api

import com.example.service_cat.data.model.Breed
import com.example.service_cat.data.model.Cat
import com.example.service_cat.data.model.Category
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("images/search")
    suspend fun getAllCats(): List<Cat>

    @GET("images/{id}")
    suspend fun getCatById(@Path("{id}") id:String): Cat

    @GET("breeds/search")
    suspend fun getBreedByName(@Query("{q}") name:String): Breed

}