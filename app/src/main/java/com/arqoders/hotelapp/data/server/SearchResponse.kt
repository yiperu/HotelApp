package com.arqoders.hotelapp.data.server

data class SearchResponse(
    val term: String,
    val suggestions: List<Group>
)