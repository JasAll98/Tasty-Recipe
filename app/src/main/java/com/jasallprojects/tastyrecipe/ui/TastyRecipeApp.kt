@file:OptIn(ExperimentalMaterial3Api::class)

package com.jasallprojects.tastyrecipe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jasallprojects.tastyrecipe.R
import com.jasallprojects.tastyrecipe.ui.screens.MainScreen
import com.jasallprojects.tastyrecipe.ui.screens.TastyRecipeViewModel

@Preview(showSystemUi = true)
@Composable
fun TastyRecipeAppPreview() {
    TastyRecipeApp()
}

@Composable
fun TastyRecipeApp(modifier: Modifier = Modifier) {
//    val scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier,
        topBar = {
            TastyRecipeTopBar()
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            val tastyRecipeViewModel: TastyRecipeViewModel =
                viewModel(factory = TastyRecipeViewModel.Factory)
            MainScreen(
                updateTag = { text ->
                    tastyRecipeViewModel.updateRecipe(text)
                },
                retryAction = tastyRecipeViewModel::getRecipes,
                tastyRecipeUiState = tastyRecipeViewModel.tastyRecipeUiState
            )
        }
    }
}

@Composable
fun TastyRecipeTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}