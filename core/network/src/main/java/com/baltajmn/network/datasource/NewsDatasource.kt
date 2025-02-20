package com.baltajmn.network.datasource

import com.baltajmn.network.model.ArticleApi
import com.baltajmn.network.service.NewsService

interface NewsDatasource {

    suspend fun getNews(
        q: String? = null,
        searchIn: String? = null,
        sources: String? = null,
        domains: String? = null,
        from: String? = null,
        to: String? = null
    ): List<ArticleApi>

    suspend fun getTop(
        q: String? = null,
        country: String? = null,
        category: String? = null
    ): List<ArticleApi>

    suspend fun getTopSources(
        q: String? = null,
        sources: String? = null
    ): List<ArticleApi>

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
    ): List<ArticleApi> {
        return newsService.getEverything(
            q = q,
            searchIn = searchIn,
            sources = sources,
            domains = domains,
            from = from,
            to = to
        ).articles
    }

    override suspend fun getTop(q: String?, country: String?, category: String?): List<ArticleApi> {
        return newsService.getTop(q = q, country = country, category = category).articles
    }

    override suspend fun getTopSources(q: String?, sources: String?): List<ArticleApi> {
        return newsService.getTopSources(q = q, sources = sources).articles
    }

}