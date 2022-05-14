package com.example.catfacts

import com.example.catfacts.network.CatFactsApiService
import com.example.catfacts.network.CatFactsRepository
import com.example.catfacts.viewModels.MainScreenViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://cat-fact.herokuapp.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CatFactsApiService::class.java)
    }
    single {
        CatFactsRepository(get())
    }
    viewModel {
        MainScreenViewModel(get())
    }

}