package com.example.online_data_example.ui.screens.preview

import com.example.online_data_example.ui.screens.home.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface  PhotoService{
    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") photoId: String) : Response<Photo>
}