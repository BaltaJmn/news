package com.baltajmn.features.home.domain

import com.baltajmn.data.repository.NewsRepository

interface GetNewsUseCase {

    suspend operator fun invoke(
        q: String? = null,
        searchIn: String? = null,
        sources: String? = null,
        domains: String? = null,
        from: String? = null,
        to: String? = null
    ): String

}

class GetNews(
    private val newsRepository: NewsRepository
) : GetNewsUseCase {

    override suspend fun invoke(
        q: String?,
        searchIn: String?,
        sources: String?,
        domains: String?,
        from: String?,
        to: String?
    ): String {
        return newsRepository.getNews(q, searchIn, sources, domains, from, to)
    }

}