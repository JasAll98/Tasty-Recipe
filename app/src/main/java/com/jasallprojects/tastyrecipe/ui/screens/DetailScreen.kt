package com.jasallprojects.tastyrecipe.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.jasallprojects.tastyrecipe.R
import com.jasallprojects.tastyrecipe.model.Recipe

@Composable
fun DetailScreen(recipe: Recipe, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.recipe_photo),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(R.string.ingredients),
            style = MaterialTheme.typography.labelMedium
        )
        LazyColumn {
            items(recipe.ingredients) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}
