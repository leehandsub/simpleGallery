package com.example.simplegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.simplegallery.ui.screen.photolist.PhotoListScreen
import com.example.simplegallery.ui.screen.photolist.PhotoListViewModel
import com.example.simplegallery.ui.theme.SimpleGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val photoListViewModel: PhotoListViewModel by viewModels()
        photoListViewModel.getPhotos()

        setContent {
            SimpleGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PhotoListScreen(photoListViewModel)
                }
            }
        }
    }
}

