package com.ramazantiftik.composemovieapp.data.repository

import com.ramazantiftik.composemovieapp.data.remote.MovieAPI
import com.ramazantiftik.composemovieapp.data.remote.dto.MovieDetailDto
import com.ramazantiftik.composemovieapp.data.remote.dto.MoviesDto
import com.ramazantiftik.composemovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
}