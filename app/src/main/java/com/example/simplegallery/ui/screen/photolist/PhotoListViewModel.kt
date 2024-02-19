package com.example.simplegallery.ui.screen.photolist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplegallery.model.Photo
import com.example.simplegallery.repository.PhotoListRepository
import kotlinx.coroutines.launch
import java.io.IOException

class PhotoListViewModel(private val photoListRepository: PhotoListRepository) : ViewModel() {
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
                _photos = photoListRepository.getPhotos()
                Log.e("viewmodelSocpe", Thread.currentThread().name)
            } catch (e: IOException) {
                _isConnect = false
            }
        }
    }

    fun getSearchAuthorPhoto(searchWord: String) {
        if (searchWord.isBlank()) {
            getPhotos()
        } else {
            _photos = _photos.filter { it.author.contains(searchWord) }
        }
    }
}

