package simplegallery.example.simplegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import simplegallery.example.simplegallery.di.ViewModelFactory
import simplegallery.example.simplegallery.model.Photo
import simplegallery.example.simplegallery.ui.screen.photodetail.PhotoDetailScreen
import simplegallery.example.simplegallery.ui.screen.photolist.PhotoListScreen
import simplegallery.example.simplegallery.ui.screen.photolist.PhotoListViewModel
import simplegallery.example.simplegallery.ui.theme.SimpleGalleryTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var photoListViewModel: PhotoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ApplicationClass).applicationGraph.inject(this)
        photoListViewModel =
            ViewModelProvider(this, viewModelFactory)[PhotoListViewModel::class.java]


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
