package com.github.artnehay.lunatv.domain.model

data class Movie(
    val id: String,
    val videoUri: String,
    val subtitleUri: String?,
    val posterUri: String,
    val name: String,
    val description: String,
)