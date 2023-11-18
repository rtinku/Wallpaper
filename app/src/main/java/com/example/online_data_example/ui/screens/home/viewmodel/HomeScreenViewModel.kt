package com.example.online_data_example.ui.screens.home.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.online_data_example.ui.screens.home.RandomPhotoService
import com.example.online_data_example.ui.screens.home.models.Photo
import com.example.online_data_example.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

   private val _photo: MutableState<Photo?> = mutableStateOf<Photo?>(null)
    val photo: State<Photo?> = _photo


    private val _loading: MutableState<Boolean> = mutableStateOf<Boolean>(false)
    val loading: State<Boolean> = _loading


    init {
        fetchData()
    }

    fun fetchData() {

       _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val res =
                    Utils.getRetrofitObject().create(RandomPhotoService::class.java).getRandomPhoto()
                _photo.value = res.body()
                _loading.value = false
            }catch (e:Exception){
                Log.e("AAA",e.message.toString())
                _loading.value = false
            }

        }
    }

}

class HomeScreenViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            return HomeScreenViewModel() as T
        }
        throw IllegalArgumentException("Unable to Create ViewModel")
    }
}