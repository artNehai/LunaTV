package com.github.artnehay.lunatv.domain.repository

import com.github.artnehay.lunatv.domain.model.HomeSection

interface MovieRepository {
    suspend fun fetchMoviesBySection(): Result<List<HomeSection>>
}