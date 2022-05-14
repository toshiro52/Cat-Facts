package com.example.catfacts.network

import com.example.catfacts.model.CatFact
import retrofit2.http.GET

interface CatFactsApiService {

    @GET("/facts/random?animal_type=cat&amount=30")
    suspend fun getCatFacts() : List<CatFact>
}