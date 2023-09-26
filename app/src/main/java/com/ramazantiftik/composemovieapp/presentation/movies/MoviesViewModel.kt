package com.ramazantiftik.composemovieapp.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramazantiftik.composemovieapp.domain.use_case.get_movies.GetMovieUseCase
import com.ramazantiftik.composemovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel(){

    private val _state= mutableStateOf<MovieState>(MovieState())
    val state : State<MovieState> = _state

    init {
        getMovies(_state.value.search)
    }

    private var job : Job? = null

    private fun getMovies(search: String){

        job?.cancel()

        job=getMovieUseCase.executeGetMovies(search).onEach {

            when(it){

                is Resource.Success -> {
                    _state.value= MovieState(movies = it.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value= MovieState(error = it.message ?: "Error!")
                }

                is Resource.Error -> {
                    _state.value= MovieState(isLoading = true)
                }

            }

        }.launchIn(viewModelScope)

    }

    fun onEvent(event: MoviesEvent){

        when(event){

            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }

            //is "another event" -> {}

        }

    }

}