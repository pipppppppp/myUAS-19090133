package com.example.uas19090133.model

import com.example.uas19090133.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //base url => alamat utama dari rest api yang digunakan
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    //agar dapat dipanggil dari mana saja
    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }
}