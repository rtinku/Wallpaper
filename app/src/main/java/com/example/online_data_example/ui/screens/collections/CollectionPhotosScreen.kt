package com.example.online_data_example.ui.screens.collections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun CollectionPhotosScreen(id: String,onItemClick : (photoId:String)->Unit) {
    val collectionsViewModel: CollectionPhotosViewModel =
        viewModel(factory = CollectionPhotosViewModelFactory(id))

    CollectionContent(collectionsViewModel = collectionsViewModel,onItemClick = onItemClick)
}

@Composable
fun CollectionContent(
    collectionsViewModel: CollectionPhotosViewModel,
    onItemClick : (photoId:String)->Unit
) {

    val state = remember {
        collectionsViewModel.collections
    }

    Scaffold(topBar = { CollectionPhotoTopBar() }) {


        if (state.value.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color.Green, strokeWidth = 4.dp

                )
            }
        }

        LazyColumn(modifier = Modifier.padding(it)) {

            state.value.collections?.map { collections ->
                item(
                    key = collections?.id,
                    content = {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clickable{
                                    onItemClick(collections?.id ?: "")
                                }


                        ) {
                            AsyncImage(
                                model = collections?.urls?.regular,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                            )
                        }
                    },

                    )
            }?.toList()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionPhotoTopBar() {
    TopAppBar(
        title = { Text(text = "Collections") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        ),
    )
}