package com.example.simplegallery.repository

import com.example.simplegallery.model.Photo
import javax.inject.Inject

class PhotoListRepository @Inject constructor(private val photoListRemoteDataSource: PhotoListRemoteDataSource) {
    suspend fun getPhotos(): List<Photo> {
        return photoListRemoteDataSource.getPhotos()
    }
}