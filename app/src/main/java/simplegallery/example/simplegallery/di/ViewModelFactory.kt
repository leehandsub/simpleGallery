package simplegallery.example.simplegallery.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import simplegallery.example.simplegallery.repository.PhotoListRepository
import simplegallery.example.simplegallery.ui.screen.photolist.PhotoListViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val photoListRepository: PhotoListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoListViewModel(photoListRepository) as T
    }
}