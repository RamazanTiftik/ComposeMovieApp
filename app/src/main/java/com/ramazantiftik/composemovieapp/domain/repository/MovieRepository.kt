package com.ramazantiftik.composemovieapp.domain.repository

import com.ramazantiftik.composemovieapp.data.remote.dto.MovieDetailDto
import com.ramazantiftik.composemovieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String) : MoviesDto

    suspend fun getMovieDetail(imdbId: String) : MovieDetailDto

}