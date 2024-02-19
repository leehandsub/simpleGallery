package com.example.simplegallery.repository

import com.example.simplegallery.model.Photo
import com.example.simplegallery.network.photoApi

class PhotoListRemoteDataSource {
    suspend fun getPhotos(): List<Photo> {
        return photoApi.getPhotos()
    }
}