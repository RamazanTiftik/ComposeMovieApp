package com.ramazantiftik.composemovieapp.domain.use_case.get_movie_detail

import com.ramazantiftik.composemovieapp.data.remote.dto.toMovieDetail
import com.ramazantiftik.composemovieapp.data.remote.dto.toMovieList
import com.ramazantiftik.composemovieapp.domain.model.Movie
import com.ramazantiftik.composemovieapp.domain.model.MovieDetail
import com.ramazantiftik.composemovieapp.domain.repository.MovieRepository
import com.ramazantiftik.composemovieapp.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun executeGetMovieDetail(imdbID: String) : kotlinx.coroutines.flow.Flow<Resource<MovieDetail>> = flow {
        try {

            emit(Resource.Loading())
            val movieDetail=repository.getMovieDetail(imdbID)
            emit(Resource.Success(movieDetail.toMovieDetail()))

        } catch (e: Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }

}