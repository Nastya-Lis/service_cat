package com.example.service_cat.data.repository

import com.example.service_cat.data.api.Api
import com.example.service_cat.data.model.Cat

class CatRepository(private val apiCat: Api) {

    suspend fun getCats(): List<Cat> = apiCat.getAllCats()

    suspend fun getBreedByName(breed:String) = apiCat.getBreedByName(breed)

    suspend fun getCatById(id_cat:String) = apiCat.getCatById(id_cat)

}