package com.example.catslist.network

import com.example.catslist.model.CatsListModel
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Headers

interface RequestEndpoint {

    companion object{

        private const val ENDPOINT = "/3/gallery/search/?q=cats"
        private const val KEY = "Authorization: Client-ID 1ceddedc03a5d71"

    }

    @Headers(KEY)
    @GET(ENDPOINT)
    fun sendRequest() : Maybe<CatsListModel>

}