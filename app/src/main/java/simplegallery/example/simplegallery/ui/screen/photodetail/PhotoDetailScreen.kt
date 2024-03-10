package simplegallery.example.simplegallery.ui.screen.photodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import simplegallery.example.simplegallery.model.Photo

@Composable
fun PhotoDetailScreen(photo: Photo) {
    Column {
        Text(text = "author : ${photo.author}")
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.downloadUrl)
                .crossfade(true)
                .build(),
            contentDescription = photo.id,
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}