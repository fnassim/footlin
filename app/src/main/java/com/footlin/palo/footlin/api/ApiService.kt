package com.footlin.palo.footlin.api

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by user on 6/10/17.
 */

interface ApiService {
    @GET("products.json")
    fun getProducts(): String

    @GET("products/{id}.json")
    fun getProduct(@Path("id") user: String): String
}