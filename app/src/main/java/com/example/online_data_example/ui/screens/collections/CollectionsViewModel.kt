package com.example.online_data_example.ui.screens.collections

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import com.example.online_data_example.ui.screens.collections.models.Collections
import com.example.online_data_example.utils.Utils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CollectionsViewModel : ViewModel() {

    private val _collections: MutableState<CollectionUiState> = mutableStateOf(CollectionUiState())
    val collections: State<CollectionUiState> = _collections;

//    var _collections: Flow<PagingData<Collections>> = MutableStateFlow(value = PagingData.empty());
//    var collections: Flow<PagingData<Collections>> = _collections

    init {
        fetchPagingCollections()
    }


    fun fetchPagingCollections() {

        _collections.value = CollectionUiState(collectionss = Pager<Int,Collections>(
            initialKey = 1,
            config = PagingConfig(
                pageSize = 10,
            ), pagingSourceFactory = {
                CollectionPageSource()
            }).flow.cachedIn(viewModelScope)
        )


    }
}

class CollectionPageSource : PagingSource<Int, Collections>() {

    override fun getRefreshKey(state: PagingState<Int, Collections>): Int? {
        Log.e("TAG", "getRefreshKey: :::: ${state.anchorPosition}")
        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Collections> {
        return try {
            val currentPage = params.key ?: 1
            Log.e("TAG", "load: ::::: ${currentPage}  ${params.loadSize}")

            val collections =
                Utils.getRetrofitObject().create(CollectionServices::class.java)
                    .getCollections(page = currentPage, perPage = params.loadSize)
                    .body()!!
            LoadResult.Page<Int,Collections>(
                data = collections,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey =
                if (collections.isEmpty()) null else currentPage + 1
            )
        } catch (ex: Exception) {
            Log.e("TAG", "load: :::: ${ex.message}")
            return LoadResult.Error(ex)
        }

    }

}

data class CollectionUiState(
    var collectionss: Flow<PagingData<Collections>> = MutableStateFlow(value = PagingData.empty()),
)

class CollectionsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectionsViewModel::class.java)) {
            return CollectionsViewModel() as T
        }

        throw IllegalArgumentException("Unable To create CollectionsViewModel")

    }
}