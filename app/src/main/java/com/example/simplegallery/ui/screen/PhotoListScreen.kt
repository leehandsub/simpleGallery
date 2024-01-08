package com.example.simplegallery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.simplegallery.model.Photo


@Composable
fun PhotoListScreen(photos: List<Photo>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(photos.size) { index ->
            val item = photos[index]
            PhotoItem(item)
        }
    }
}

@Composable
fun PhotoItem(photo: Photo) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.downloadUrl)
                .crossfade(true)
                .build(),
            contentDescription = photo.id,
            modifier = Modifier
                .aspectRatio(1f)//그냥 1대1로 강제로 늘리는거인듯?
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}

