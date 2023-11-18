package com.example.online_data_example.ui.screens.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.online_data_example.ui.screens.CustomApplication
import com.example.online_data_example.ui.screens.preview.viewmodel.PreviewViewModel
import com.example.online_data_example.ui.screens.preview.viewmodel.PreviewViewModelFactory
import com.example.online_data_example.utils.showLoader
import kotlinx.coroutines.launch

@Composable
fun PreviewScreen(photoId: String) {
    val previewModel: PreviewViewModel =
        viewModel(
            factory = PreviewViewModelFactory(
                application = LocalContext.current.applicationContext as CustomApplication,
                photoId = photoId
            )
        )
    Scaffold(snackbarHost = {
        SnackbarHost(hostState = previewModel.snackbarHostState)
    }) {
        var padding = it
        PreviewContent(previewModel)
    }
}

@Composable
fun PreviewContent(previewModel: PreviewViewModel) {
    val state = previewModel.state
    val scope = rememberCoroutineScope()


    if (state.value.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        PreviewWithTools {
            PhotoImage(state.value.photo?.urls?.regular, onSuccess = { state ->
                previewModel.bitmap = state.result.drawable.toBitmap()

            })
            Info(
                color = Color(color = android.graphics.Color.parseColor(state.value.photo?.color)),
                getInfo = {
                    if (state.value.photo?.description?.isNotEmpty() == true) {
                        scope.launch {
                            previewModel.snackbarHostState.showSnackbar(
                                state.value.photo?.description ?: ""
                            )
                        }
                    }

                },
                setWallpaper = {
                    if (!previewModel.showSetWallpaperDialog.value) {
                        previewModel.showSetWallpaperDialog.value = true
                    }
                }
            )
        }
    }

    if (previewModel.showSetWallpaperDialog.value) {
        SetWallpaperDialog(
            onDismissRequest = {
                previewModel.showSetWallpaperDialog.value = false
            },
            setHomeScreenWallpaper = {

                previewModel.setHomeScreenWallpaper()

            },
            setLockScreenWallpaper = {
                previewModel.setLockScreenWallpaper()
            },
            setBothScreenWallpaper = {
                previewModel.setBothScreenWallpaper()
            }
        )
    }

    if (previewModel.showLoaderDialog.value) {
        showLoader()
    }
}


@Composable
fun PhotoImage(photoUrl: String?, onSuccess: ((AsyncImagePainter.State.Success) -> Unit)?) {
    AsyncImage(
        model = photoUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        onSuccess = onSuccess
    )
}

@Composable
fun Info(color: Color, getInfo: () -> Unit, setWallpaper: () -> Unit) {

    Box(
        contentAlignment = Alignment.TopEnd, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, end = 16.dp)
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Button(
                onClick = setWallpaper,
            ) {
                Text(text = "Set Wallpaper")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(color = color)
                    .padding(8.dp)
                    .clickable(onClick = getInfo)

            )
        }

    }

}


@Composable
fun PreviewFooter(lockScreen: () -> Unit, homeScreen: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()

            .padding(horizontal = 16.dp),

        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = lockScreen, modifier = Modifier.weight(1f)) {
            Text(text = "Lock Screen")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = homeScreen, modifier = Modifier.weight(1f)) {
            Text(text = "Home Screen")
        }
    }
}

@Composable
fun PreviewWithTools(content: @Composable BoxScope.() -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        content()
    }
}

@Composable
fun SetWallpaperDialog(
    onDismissRequest: () -> Unit,
    setHomeScreenWallpaper: () -> Unit = {},
    setLockScreenWallpaper: () -> Unit = {},
    setBothScreenWallpaper: () -> Unit = {},
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .wrapContentHeight()
                .background(color = Color.Black)
                .padding(16.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text("Set Wallpaper On ", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        onDismissRequest()
                        setHomeScreenWallpaper()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Home Screen")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        onDismissRequest()
                        setLockScreenWallpaper()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Lock Screen")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    contentPadding = PaddingValues(vertical = 16.dp),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        onDismissRequest()
                        setBothScreenWallpaper()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Home And Lock Screen")
                }
            }


        }
    }
}