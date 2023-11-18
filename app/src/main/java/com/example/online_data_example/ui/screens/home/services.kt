package com.example.online_data_example.ui.screens.home

import com.example.online_data_example.ui.screens.home.models.Photo
import retrofit2.Response
import retrofit2.http.GET

interface RandomPhotoService {
    @GET("/photos/random")
    suspend fun getRandomPhoto(): Response<Photo>
}