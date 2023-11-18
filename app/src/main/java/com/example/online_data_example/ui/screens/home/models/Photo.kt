package com.example.online_data_example.ui.screens.home.models

import com.google.gson.annotations.SerializedName


data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("color") val color: String,
    @SerializedName("description") val description: String,
    @SerializedName("urls") val urls: Urls
)


data class Urls(
    @SerializedName("raw") val raw: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("full") val full: String
)