package com.github.artnehay.lunatv.data

import com.github.artnehay.lunatv.data.fake.FakeMoviesBySection
import com.github.artnehay.lunatv.domain.model.HomeSection
import com.github.artnehay.lunatv.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    override suspend fun fetchMoviesBySection(): Result<List<HomeSection>> {
        return Result.success(FakeMoviesBySection)
    }
}