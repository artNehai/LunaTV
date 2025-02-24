package com.github.artnehay.lunatv.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.artnehay.lunatv.domain.model.HomeSection
import com.github.artnehay.lunatv.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val movieRepository: MovieRepository,
) : ViewModel() {

    private val _homeSections = MutableStateFlow(listOf<HomeSection>())
    val homeSections = _homeSections.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.fetchMoviesBySection()
                .onSuccess { result ->
                    _homeSections.update { result }
                }
        }
    }
}