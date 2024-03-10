package simplegallery.example.simplegallery.repository

import simplegallery.example.simplegallery.model.Photo
import simplegallery.example.simplegallery.network.PhotoApi
import javax.inject.Inject

class PhotoListRemoteDataSource @Inject constructor(private val photoApi: PhotoApi) {
    suspend fun getPhotos(): List<Photo> {
        return photoApi.getPhotos()
    }
}