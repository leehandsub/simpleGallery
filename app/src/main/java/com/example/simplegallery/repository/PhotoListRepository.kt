package com.example.simplegallery.repository

import com.example.simplegallery.model.Photo

class PhotoListRepository(private val photoListRemoteDataSource: PhotoListRemoteDataSource) {
    suspend fun getPhotos(): List<Photo> {
        return photoListRemoteDataSource.getPhotos()
    }
}