package com.baltajmn.data.repository

import com.baltajmn.data.worker.Syncable
import com.baltajmn.network.datasource.NewsDatasource

interface NewsRepository : Syncable {

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
    ): String {
        return newsDataSource.getNews(q, searchIn, sources, domains, from, to)
    }

    override suspend fun getTop(q: String?, country: String?, category: String?): String {
        return newsDataSource.getTop(q, country, category)
    }

    override suspend fun getTopSources(q: String?, sources: String?): String {
        return newsDataSource.getTopSources(q, sources)
    }

}