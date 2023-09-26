package com.ramazantiftik.composemovieapp.presentation.movies

import com.ramazantiftik.composemovieapp.domain.model.Movie

data class MovieState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "batman"
)