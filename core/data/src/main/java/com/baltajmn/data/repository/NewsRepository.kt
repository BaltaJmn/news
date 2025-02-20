package com.baltajmn.data.repository

import com.baltajmn.data.worker.Syncable
import com.baltajmn.network.datasource.NewsDatasource
import com.baltajmn.network.model.ArticleApi
import com.baltajmn.network.model.SourceApi
import com.baltajmn.template.core.common.model.Article

interface NewsRepository : Syncable {

    suspend fun getNews(
        q: String? = null,
        searchIn: String? = null,
        sources: String? = null,
        domains: String? = null,
        from: String? = null,
        to: String? = null
    ): List<Article>

    suspend fun getTop(
        q: String? = null,
        country: String? = null,
        category: String? = null
    ): List<Article>

    suspend fun getTopSources(
        q: String? = null,
        sources: String? = null
    ): List<Article>

}

class DefaultNewsRepository(
    private val newsDataSource: NewsDatasource
) : NewsRepository {

    override suspend fun sync(): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getNews(
        q: String?,
        searchIn: String?,
        sources: String?,
        domains: String?,
        from: String?,
        to: String?
    ): List<Article> {
        return newsDataSource.getNews(q, searchIn, sources, domains, from, to).map { it.toDomain() }
    }

    override suspend fun getTop(q: String?, country: String?, category: String?): List<Article> {
        return newsDataSource.getTop(q, country, category).map { it.toDomain() }
    }

    override suspend fun getTopSources(q: String?, sources: String?): List<Article> {
        return newsDataSource.getTopSources(q, sources).map { it.toDomain() }
    }

}