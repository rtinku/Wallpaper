package com.example.online_data_example.ui.screens.collections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.online_data_example.utils.ErrorMessage
import com.example.online_data_example.utils.LoadingNextPageItem
import com.example.online_data_example.utils.PageLoader

@Composable
fun CollectionScreen(onItemClick: (id: String) -> Unit) {
    val collectionsViewModel: CollectionsViewModel =
        viewModel(factory = CollectionsViewModelFactory())

    CollectionContent(collectionsViewModel = collectionsViewModel, onItemClick = onItemClick)
}

@Composable
fun CollectionContent(
    collectionsViewModel: CollectionsViewModel,
    onItemClick: (id: String) -> Unit
) {

    val pagingItems = collectionsViewModel.collections.value.collectionss.collectAsLazyPagingItems()

    Scaffold(topBar = { CollectionTopBar() }) {

        LazyColumn(modifier = Modifier.padding(it)) {
            items(pagingItems.itemCount) { index: Int ->
                pagingItems.apply {
                    val iii = this[index]
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)


                    ) {
                        AsyncImage(
                            model = iii?.coverPhoto?.urls?.regular,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clickable {
                                onItemClick(iii?.id ?: "")
                            }
                        )
                    }
                }


            }
            pagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { PageLoader(modifier = Modifier.fillParentMaxSize()) }

                    }

                    loadState.refresh is LoadState.Error -> {
                        val error = this.loadState.refresh as LoadState.Error
                        item {
                            ErrorMessage(
                                modifier = Modifier.fillParentMaxSize(),
                                message = error.error.localizedMessage!!,
                                onClickRetry = { retry() })
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item { LoadingNextPageItem(modifier = Modifier) }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = this.loadState.append as LoadState.Error
                        item {
                            ErrorMessage(
                                modifier = Modifier,
                                message = error.error.localizedMessage!!,
                                onClickRetry = { retry() })
                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.padding(4.dp)) }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionTopBar() {
    TopAppBar(
        title = { Text(text = "Collections") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        ),
    )
}