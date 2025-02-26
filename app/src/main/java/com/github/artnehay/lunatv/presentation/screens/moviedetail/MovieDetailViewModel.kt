package com.github.artnehay.lunatv.presentation.screens.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.github.artnehay.lunatv.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
//    val movieRepository: MovieRepository,
) : ViewModel() {

    private val _movieId = savedStateHandle.toRoute<Screen.MovieDetail>().movieId

    /*private val _homeSections = MutableStateFlow(listOf<HomeSection>())
    val homeSections = _homeSections.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.fetchMoviesBySection()
                .onSuccess { result ->
                    _homeSections.update { result }
                }
        }
    }*/
}