package simplegallery.example.simplegallery.ui.common

import simplegallery.example.simplegallery.repository.PhotoListRemoteDataSource
import simplegallery.example.simplegallery.repository.PhotoListRepository
import simplegallery.example.simplegallery.ui.screen.photolist.PhotoListViewModel

//object AppContainer {
//    private val photoListRemoteDataSource = PhotoListRemoteDataSource()
//    val photoListRepository = PhotoListRepository(photoListRemoteDataSource)
//    var photoListContainer: PhotoListContainer? = null
//}
//
//class PhotoListContainer(private val photoListRepository: PhotoListRepository) {
//    val photoListViewModelFactory = PhotoListViewModelFactory(photoListRepository)
//}
//
//class PhotoListViewModelFactory(private val photoListRepository: PhotoListRepository) {
//    fun create(): PhotoListViewModel {
//        return PhotoListViewModel(photoListRepository)
//    }
//}