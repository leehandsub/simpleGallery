package com.example.simplegallery.repository

import com.example.simplegallery.model.Photo
import com.example.simplegallery.network.PhotoApi
import javax.inject.Inject

class PhotoListRemoteDataSource @Inject constructor(private val photoApi: PhotoApi) {
    suspend fun getPhotos(): List<Photo> {
        return photoApi.getPhotos()
    }
}