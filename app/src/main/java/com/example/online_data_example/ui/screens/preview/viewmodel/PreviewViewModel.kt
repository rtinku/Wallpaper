package com.example.online_data_example.ui.screens.preview.viewmodel

import android.app.Application
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.online_data_example.ui.screens.CustomApplication
import com.example.online_data_example.ui.screens.home.models.Photo
import com.example.online_data_example.ui.screens.preview.PhotoService
import com.example.online_data_example.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PreviewViewModel(application: Application, private val photoId: String) :
    AndroidViewModel(application) {

    private val _state: MutableState<PreviewUiState> =
        mutableStateOf<PreviewUiState>(PreviewUiState())
    val state: State<PreviewUiState> = _state

    val showSetWallpaperDialog: MutableState<Boolean> = mutableStateOf(false)
    val showLoaderDialog: MutableState<Boolean> = mutableStateOf(false)

    var snackbarHostState: SnackbarHostState = SnackbarHostState()

    var bitmap: Bitmap? = null

    init {
        fetchPhoto()
    }

    private fun fetchPhoto() {
        _state.value = PreviewUiState(isLoading = true)
        viewModelScope.launch {
            val res = Utils.getRetrofitObject().create(PhotoService::class.java).getPhoto(photoId)
            Log.e(TAG, "fetchPhoto: ${res.code()}")
            if (res.isSuccessful) {

                _state.value = PreviewUiState(isLoading = false, photo = res.body())
            } else {
                _state.value =
                    PreviewUiState(isLoading = false, errorMsg = res.errorBody()!!.string())
            }
        }
    }

    companion object {
        const val TAG: String = "PreviewViewModel"
    }

    fun setHomeScreenWallpaper() {
        val app = getApplication<CustomApplication>()
        val wallpaperManager = WallpaperManager.getInstance(app.applicationContext)
        showLoaderDialog.value = true
        val rrr = viewModelScope.launch(Dispatchers.IO) {
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
        }

        rrr.invokeOnCompletion {
            showLoaderDialog.value = false
        }

    }

    fun setLockScreenWallpaper() {
        val app = getApplication<CustomApplication>()
        val wallpaperManager = WallpaperManager.getInstance(app.applicationContext)
        showLoaderDialog.value = true
        val rrr = viewModelScope.launch(Dispatchers.IO) {
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
        }

        rrr.invokeOnCompletion {
            showLoaderDialog.value = false
        }
    }

    fun setBothScreenWallpaper() {
        val app = getApplication<CustomApplication>()
        val wallpaperManager = WallpaperManager.getInstance(app.applicationContext)
        showLoaderDialog.value = true
        val rrr = viewModelScope.launch(Dispatchers.IO) {
            wallpaperManager.setBitmap(bitmap)
        }

        rrr.invokeOnCompletion {
            showLoaderDialog.value = false
        }
    }


    fun homeScreenPreview(){
        val app = getApplication<CustomApplication>()
        val wallpaperManager = WallpaperManager.getInstance(app.applicationContext)
    }
}

data class PreviewUiState(
    val photo: Photo? = null,
    val isLoading: Boolean = false,
    val errorMsg: String? = null
)

class PreviewViewModelFactory(val application: Application, private val photoId: String) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreviewViewModel::class.java)) {
            return PreviewViewModel(application = application, photoId = photoId) as T
        }
        throw IllegalArgumentException("Unable to Create ViewModel")
    }


}