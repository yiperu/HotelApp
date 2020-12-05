package com.arqoders.data.source

interface LocationDataSource {
    suspend fun findLastRegion(): String?
}