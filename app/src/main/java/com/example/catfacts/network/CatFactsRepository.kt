package com.example.catfacts.network

class CatFactsRepository(private val apiService: CatFactsApiService) {

    suspend fun getFacts() = apiService.getCatFacts()
}