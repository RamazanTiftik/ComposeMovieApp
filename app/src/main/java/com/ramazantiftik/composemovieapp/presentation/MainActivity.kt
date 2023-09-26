package com.ramazantiftik.composemovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramazantiftik.composemovieapp.presentation.movie_detail.views.MovieDetailScreen
import com.ramazantiftik.composemovieapp.presentation.movies.views.MovieScreen
import com.ramazantiftik.composemovieapp.presentation.ui.theme.ComposeMovieAppTheme
import com.ramazantiftik.composemovieapp.util.Constans.IMDB_ID
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovieAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route){

                        composable(Screen.MovieScreen.route){
                            MovieScreen(navController = navController)
                        }

                        composable(Screen.MovieDetailScreen.route+"/{${IMDB_ID}}"){
                            MovieDetailScreen()
                        }

                    }

                }
            }
        }
    }
}
