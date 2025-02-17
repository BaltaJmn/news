package com.baltajmn.network.datasource

import com.baltajmn.network.service.NewsService

interface NewsDatasource {

    suspend fun getNews(
        q: String? = null,
        searchIn: String? = null,
        sources: String? = null,
        domains: String? = null,
        from: String? = null,
        to: String? = null
    ): String

    suspend fun getTop(
        q: String? = null,
        country: String? = null,
        category: String? = null
    ): String

    suspend fun getTopSources(
        q: String? = null,
        sources: String? = null
    ): String

}

class DefaultNewsDatasource(
    private val newsService: NewsService,
) : NewsDatasource {

    override suspend fun getNews(
        q: String?,
        searchIn: String?,
        sources: String?,
        domains: String?,
        from: String?,
        to: String?
    ): String {
        return newsService.getEverything(
            q = q,
            searchIn = searchIn,
            sources = sources,
            domains = domains,
            from = from,
            to = to
        )
    }

    override suspend fun getTop(q: String?, country: String?, category: String?): String {
        return newsService.getTop(q = q, country = country, category = category)
    }

    override suspend fun getTopSources(q: String?, sources: String?): String {
        return newsService.getTopSources(q = q, sources = sources)
    }

}