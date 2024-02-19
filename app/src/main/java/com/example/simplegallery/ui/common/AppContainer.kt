package com.example.simplegallery.ui.common

import com.example.simplegallery.repository.PhotoListRemoteDataSource
import com.example.simplegallery.repository.PhotoListRepository
import com.example.simplegallery.ui.screen.photolist.PhotoListViewModel

object AppContainer {
    private val photoListRemoteDataSource = PhotoListRemoteDataSource()
    val photoListRepository = PhotoListRepository(photoListRemoteDataSource)
    var photoListContainer: PhotoListContainer? = null
}

class PhotoListContainer(private val photoListRepository: PhotoListRepository) {
    val photoListViewModelFactory = PhotoListViewModelFactory(photoListRepository)
}

class PhotoListViewModelFactory(private val photoListRepository: PhotoListRepository) {
    fun create(): PhotoListViewModel {
        return PhotoListViewModel(photoListRepository)
    }
}