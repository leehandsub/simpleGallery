package com.example.simplegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplegallery.model.Photo
import com.example.simplegallery.repository.PhotoListRemoteDataSource
import com.example.simplegallery.repository.PhotoListRepository
import com.example.simplegallery.ui.screen.photodetail.PhotoDetailScreen
import com.example.simplegallery.ui.screen.photolist.PhotoListScreen
import com.example.simplegallery.ui.screen.photolist.PhotoListViewModel
import com.example.simplegallery.ui.theme.SimpleGalleryTheme

class MainActivity : ComponentActivity() {
    private lateinit var photoListViewModel: PhotoListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val photoListViewModel: PhotoListViewModel by viewModels()

        val photoListRemoteDataSource = PhotoListRemoteDataSource()
        val photoListRepository = PhotoListRepository(photoListRemoteDataSource)
        photoListViewModel = PhotoListViewModel(photoListRepository)

        photoListViewModel.getPhotos()

        setContent {
            SimpleGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(photoListViewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation(photoListViewModel: PhotoListViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "photoList") {
        composable("photoList") {
            PhotoListScreen(photoListViewModel, navController)
        }
        composable(
            route = "detail",
        ) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Photo>("photo")
            if (result != null) {
                PhotoDetailScreen(result)
            }
        }
    }
}

