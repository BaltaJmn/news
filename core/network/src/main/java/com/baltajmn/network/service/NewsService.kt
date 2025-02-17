package com.baltajmn.network.service


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NewsService(
    private val httpClient: HttpClient,
) {

    suspend fun getEverything(
        q: String? = null,
        searchIn: String? = null,
        sources: String? = null,
        domains: String? = null,
        from: String? = null,
        to: String? = null,
        language: String? = null,
        sortBy: String? = null,
    ): String {
        return httpClient.get("/everything") {
            q?.let { parameter("q", it) }
            searchIn?.let { parameter("searchIn", it) }
            sources?.let { parameter("sources", it) }
            domains?.let { parameter("domains", it) }
            from?.let { parameter("from", it) }
            to?.let { parameter("to", it) }
            language?.let { parameter("language", it) }
            sortBy?.let { parameter("sortBy", it) }
        }.body()
    }

    suspend fun getTop(
        q: String? = null,
        country: String? = null,
        category: String? = null
    ): String {
        return httpClient.get("/everything") {
            q?.let { parameter("q", it) }
            country?.let { parameter("country", it) }
            category?.let { parameter("category", it) }
        }.body()
    }

    suspend fun getTopSources(
        q: String? = null,
        sources: String? = null
    ): String {
        return httpClient.get("/everything") {
            q?.let { parameter("q", it) }
            sources?.let { parameter("sources", it) }
        }.body()
    }

}