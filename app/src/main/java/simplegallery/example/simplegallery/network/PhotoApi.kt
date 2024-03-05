package simplegallery.example.simplegallery.network

import retrofit2.http.GET
import simplegallery.example.simplegallery.model.Photo

interface PhotoApi {
    @GET("v2/list")
    suspend fun getPhotos(): List<Photo>
}