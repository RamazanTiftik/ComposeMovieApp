package com.ramazantiftik.composemovieapp.presentation.movie_detail

import com.ramazantiftik.composemovieapp.domain.model.Movie
import com.ramazantiftik.composemovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)