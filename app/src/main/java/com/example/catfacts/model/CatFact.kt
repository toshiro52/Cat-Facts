package com.example.catfacts.model

import com.squareup.moshi.Json

data class CatFact(
    @Json(name = "_id") val id: String,
    @Json(name = "text") val factText: String,
    @Json(name = "updatedAt") val updateDate: String
)
