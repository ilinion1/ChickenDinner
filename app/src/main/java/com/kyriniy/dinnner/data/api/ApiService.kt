package com.kyriniy.dinnner.data.api

import com.kyriniy.dinnner.data.api.dto.Container
import retrofit2.http.GET

interface ApiService {

    @GET("plitka.json")
    suspend fun getDataServer(): Container
}