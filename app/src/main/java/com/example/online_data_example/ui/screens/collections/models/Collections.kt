package com.example.online_data_example.ui.screens.collections.models

import com.google.gson.annotations.SerializedName


data class Collections(val id:String,@SerializedName("cover_photo") val coverPhoto: CoverPhoto)

data class CoverPhoto(val id:String,val color:String,val urls:Urls)

data class Urls(
    @SerializedName("raw") val raw: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("full") val full: String
)