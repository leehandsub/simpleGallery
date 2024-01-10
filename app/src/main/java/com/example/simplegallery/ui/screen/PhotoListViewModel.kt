package com.example.simplegallery.ui.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplegallery.model.Photo
import com.example.simplegallery.network.RetrofitUtil

import kotlinx.coroutines.launch
import java.io.IOException

class PhotoListViewModel : ViewModel() {
    val photos: List<Photo>
        get() = _photos
    private var _photos: List<Photo> by mutableStateOf(emptyList())

    val isConnect: Boolean
        get() = _isConnect
    private var _isConnect: Boolean by mutableStateOf(false)

    fun getPhotos() {
        viewModelScope.launch {
            try {
                _isConnect = true
                _photos = RetrofitUtil.photoApi.getPhotos()
                Log.e("viewmodelSocpe", Thread.currentThread().name)
            } catch (e: IOException) {
                _isConnect = false
            }
        }
    }

    fun getSearchAuthorPhoto(searchWord: String) {
        if (searchWord == "") {
            getPhotos()
        } else {
            _photos = _photos.filter { it.author.contains(searchWord) }
        }
    }
}

