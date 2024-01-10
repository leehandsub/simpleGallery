package com.example.simplegallery.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.simplegallery.model.Photo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoListScreen(photos: List<Photo>) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            placeholder = { Text("검색") },
            singleLine = true,
        )

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            columns = GridCells.Fixed(2),
        ) {
            items(photos.size) { index ->
                val item = photos[index]
                PhotoItem(item)
            }
        }
    }
}

@Composable
fun PhotoItem(photo: Photo) {
    Box(
        modifier = Modifier
            .padding(5.dp)//이거 위아래 위치 바뀌면 왜 개같이 나옴???
            .clip(
                shape = RoundedCornerShape(
                    size = 16.dp,
                ),
            )
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
        Text(
            text = photo.author,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color(0x66000000))
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        )
    }
}

