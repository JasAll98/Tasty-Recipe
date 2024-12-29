package com.jasallprojects.tastyrecipe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.jasallprojects.tastyrecipe.R
import com.jasallprojects.tastyrecipe.model.Recipe


@Composable
fun MainScreen(
    updateTag: (String) -> Unit,
    retryAction: () -> Unit,
    tastyRecipeUiState: TastyRecipeUiState,
    modifier: Modifier = Modifier,
) {
    when (tastyRecipeUiState) {
        is TastyRecipeUiState.Success -> RecipeList(
            updateTag = updateTag,
            retryAction = retryAction,
            tastyRecipeUiState.recipe,
            tastyRecipeUiState.tags,
            modifier.fillMaxSize()
        )

        is TastyRecipeUiState.Loading -> LoadingScreen(modifier.fillMaxSize())
        is TastyRecipeUiState.Error -> ErrorScreen(retryAction, modifier.fillMaxSize())
    }
}


@Composable
fun RecipeList(
    updateTag: (String) -> Unit,
    retryAction: () -> Unit,
    recipes: List<Recipe>,
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    Column {
        CategoryList(updateTag = updateTag, retryAction, tags)
        LazyColumn(modifier = modifier) {
            items(recipes) { item ->
                RecipeCard(item)
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipe.image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.recipe_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(250.dp)
            )
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = recipe.name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .width(180.dp)
                )
                Spacer(Modifier.weight(1f))
                Column(
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = recipe.difficulty,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .alpha(0.7f)
                    )
                    Row(
                        modifier = Modifier.padding(end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AccessTime,
                            contentDescription = stringResource(R.string.time_icon_desc),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "${recipe.cookTimeMinutes} min",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryList(updateTag: (String) -> Unit, retryAction: () -> Unit, listTags: List<String>) {
    LazyRow(modifier = Modifier.padding(start = 16.dp)) {
        item {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable(
                        onClick = retryAction
                    )
            ) {
                Text(
                    text = "All",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
        itemsIndexed(listTags.distinct()) { index, item ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable(
                        onClick = { updateTag(item) }
                    ),
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = ProgressIndicatorDefaults.linearColor,
            strokeWidth = 18.dp,
            strokeCap = StrokeCap.Round,
            modifier = Modifier.width(100.dp)
        )
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.no_connection),
                contentDescription = stringResource(R.string.no_connection),
                modifier = Modifier.size(150.dp)
            )
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = retryAction,
                modifier = Modifier.height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.retry),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp)
                )
            }
        }
    }
}
