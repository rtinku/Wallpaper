package com.example.online_data_example.ui.screens.collections

import com.example.online_data_example.ui.screens.collections.models.Collections
import com.example.online_data_example.ui.screens.home.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionServices {
    @GET("/collections")
    suspend fun getCollections(@Query(value = "page") page : Int = 1,@Query(value = "per_page") perPage : Int = 10): Response<List<Collections>>

 @GET("/collections/{id}/photos")
    suspend fun getCollectionPhotos(@Path("id") id:String): Response<List<Photo>>

}