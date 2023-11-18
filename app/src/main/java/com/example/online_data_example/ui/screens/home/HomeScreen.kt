package com.example.online_data_example.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.online_data_example.ui.screens.home.models.Photo
import com.example.online_data_example.ui.screens.home.viewmodel.HomeScreenViewModel
import com.example.online_data_example.ui.screens.home.viewmodel.HomeScreenViewModelFactory
import com.example.online_data_example.ui.theme.Online_data_exampleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val homeScreenViewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModelFactory())

    HomeContent(homeScreenViewModel = homeScreenViewModel)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(homeScreenViewModel: HomeScreenViewModel) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val sheetState = rememberModalBottomSheetState()

    val photoState = remember {
        homeScreenViewModel.photo
    }

    val loading = remember {
        homeScreenViewModel.loading
    }
    Scaffold(
        topBar = {
            HomeScreenTopBar(onRefresh = {
                homeScreenViewModel.fetchData()
            })
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { SnackBarContent(it) })
        },
    ) {

        val modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = it)

        if (loading.value) {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.Green, strokeWidth = 2.dp)

            }
        } else {
            LazyColumn(modifier = modifier) {

                item {
                    ImageItem(
                        photoState.value,
                        sheetState = sheetState,
                        coroutineScope = scope
                    )
                }

            }
        }


    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ImageItem(
    photo: Photo?,
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    coroutineScope: CoroutineScope
) {
    Card(
        modifier = modifier
            .fillMaxSize(fraction = 1f)
            .padding(16.dp)


    ) {

        if(sheetState.currentValue != SheetValue.Hidden){
            OpenBottomSheet(sheetState)
        }

        AsyncImage(modifier = modifier.clickable(onClick = {
            onClick(
                sheetState = sheetState,
                coroutineScope = coroutineScope
            )
        }), model = photo?.urls?.regular, contentDescription = null)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
private fun onClick(sheetState: SheetState, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        sheetState.show()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenBottomSheet(sheetState: SheetState) {
    val scope = rememberCoroutineScope()
    ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
        scope.launch {
            sheetState.hide()
        }

    }){
        Box(modifier = Modifier.height(200.dp).background(color = Color.Green))
    }
}


@Composable
fun SnackBarContent(snackbarData: SnackbarData) {
    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), content = {
            Box(modifier = Modifier.wrapContentHeight()) {
                Text(text = snackbarData.visuals.message)
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun HomeScreenTopBar(onRefresh: () -> Unit) {
    TopAppBar(title = { Text(text = "Home") }, actions = {
        IconButton(onClick = onRefresh) {
            Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Refresh ")
        }
    })
}


@Preview
@Composable
fun HomeScreenPreview() {
    Online_data_exampleTheme {
        HomeScreen()
    }
}