package com.example.catslist.model

import com.google.gson.annotations.SerializedName

data class CatsListModel(

    @SerializedName("data")
    var data: MutableList<Data>,
    @SerializedName("status")
    val status: String,
    @SerializedName("sucess")
    val success: Boolean,

)

data class Data(

    @SerializedName("images")
    val images: MutableList<Images>,

)

data class Images(

    @SerializedName("link")
    val link: String,

)
