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

class PhotoListViewModel : ViewModel() {
    val photos: List<Photo>
        get() = _photos

    private var _photos: List<Photo> by mutableStateOf(emptyList())

    fun getPhotos() {
        viewModelScope.launch {
            _photos = RetrofitUtil.api.getPhotos()
            Log.e("viewmodelSocpe", Thread.currentThread().name)
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

