package com.ramazantiftik.composemovieapp.domain.use_case.get_movies

import com.ramazantiftik.composemovieapp.data.remote.dto.toMovieList
import com.ramazantiftik.composemovieapp.domain.model.Movie
import com.ramazantiftik.composemovieapp.domain.repository.MovieRepository
import com.ramazantiftik.composemovieapp.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun executeGetMovies(search: String) : kotlinx.coroutines.flow.Flow<Resource<List<Movie>>> = flow {
        try {

            emit(Resource.Loading())
            val movieList= repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error("No Movie Found!"))
            }

        } catch (e: Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }

}