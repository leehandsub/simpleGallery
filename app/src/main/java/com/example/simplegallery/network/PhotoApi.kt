package com.example.simplegallery.network

import com.example.simplegallery.model.Photo
import retrofit2.http.GET

interface PhotoApi {
    @GET("v2/list")
    suspend fun getPhotos(): List<Photo>

}