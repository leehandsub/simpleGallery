package simplegallery.example.simplegallery.repository

import simplegallery.example.simplegallery.model.Photo
import javax.inject.Inject

class PhotoListRepository @Inject constructor(private val photoListRemoteDataSource: PhotoListRemoteDataSource) {
    suspend fun getPhotos(): List<Photo> {
        return photoListRemoteDataSource.getPhotos()
    }
}