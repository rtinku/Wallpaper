package com.example.online_data_example.ui.screens.collections

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.online_data_example.ui.screens.home.models.Photo
import com.example.online_data_example.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectionPhotosViewModel(private val id: String) : ViewModel() {

    private val _collections: MutableState<CollectionPhotosUiState> = mutableStateOf(CollectionPhotosUiState())
    val collections: State<CollectionPhotosUiState> = _collections;

    init {
        fetchCollectionPhotos()
    }

    fun fetchCollectionPhotos() {
        _collections.value.isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res =
                    Utils.getRetrofitObject().create(CollectionServices::class.java)
                        .getCollectionPhotos(id = id)
                if (res.isSuccessful) {
                    _collections.value =
                        CollectionPhotosUiState(collections = res.body(), isLoading = false)
                } else {
                    _collections.value = CollectionPhotosUiState(collections = null, isLoading = false)
                }
            } catch (e: Exception) {
                Log.e("TAG", "fetchCollections: ${e.message} ")
            }

        }
    }
}

data class CollectionPhotosUiState(
    var collections: List<Photo?>? = null,
    var isLoading: Boolean = true
)

class CollectionPhotosViewModelFactory(val id: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectionPhotosViewModel::class.java)) {
            return CollectionPhotosViewModel(id = id) as T
        }

        throw IllegalArgumentException("Unable To create CollectionsViewModel")

    }
}