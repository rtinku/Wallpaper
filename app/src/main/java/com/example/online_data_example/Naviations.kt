package com.example.online_data_example

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.online_data_example.ui.screens.collections.CollectionPhotosScreen
import com.example.online_data_example.ui.screens.collections.CollectionScreen
import com.example.online_data_example.ui.screens.home.HomeScreen
import com.example.online_data_example.ui.screens.preview.PreviewScreen

enum class ROUTES(val value: String) {
    Home("home"),
    Collections("Collections"),
    Collection("Collections/{collection_id}"),
    Preview("Preview/{photo_id}"),
}

@Composable
fun Naviations() {
    val navContoller = rememberNavController()

    NavHost(navController = navContoller, startDestination = ROUTES.Collections.name) {
        composable(ROUTES.Home.value) {
            HomeScreen()
        }
        composable(ROUTES.Collections.value) {
            CollectionScreen(onItemClick = { id -> navContoller.navigate("Collections/$id") })
        }
        composable(
            ROUTES.Collection.value,
            arguments = listOf(navArgument(name = "collection_id") { type = NavType.StringType })
        ) {
            val collectionId = it.arguments?.getString("collection_id")
            CollectionPhotosScreen(id = collectionId!!, onItemClick = {photoId -> navContoller.navigate("Preview/${photoId}")})
        }
        composable(
            ROUTES.Preview.value,
            arguments = listOf(navArgument(name = "photo_id") { type = NavType.StringType })
        ) {
            val photoId = it.arguments?.getString("photo_id")
            PreviewScreen(photoId = photoId!!)
        }
    }

}