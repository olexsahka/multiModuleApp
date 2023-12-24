package com.feature.movie.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MovieScreen(viewModel: MovieSearchViewModel, navController: NavController) {

    val result = viewModel.movieList.value
    val query = viewModel.query.collectAsState()

    Scaffold(topBar = {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = query.value,
            onValueChange = {
                viewModel.setQuery(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ), placeholder = { Text(text = "Search Movie...") }, trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            }
        )

    }) {

        if (result.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        if (result.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = result.error)

            }
        }
        result.data?.let {

            if (it.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Nothing found")
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.padding(vertical = 50.dp),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    content = {
                        items(it) {

                            Box(
                                modifier = Modifier
                                    .height(200.dp)
                                    .border(width = 1.dp, color = Color.White)
                            ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .clickable {
                                            navController.navigate("movie_detail_screen_route/${it.id}")
                                        },
                                    model = it.imgUrl,
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit,
                                    placeholder = rememberVectorPainter(image = Icons.Default.Info))


                            }

                        }

                    })
            }


        }


    }


}