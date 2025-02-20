package com.baltajmn.network.model

import com.baltajmn.template.core.common.model.Article
import com.baltajmn.template.core.common.model.Source
import kotlinx.serialization.Serializable

@Serializable
data class ResultApi(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleApi>
)

@Serializable
data class ArticleApi(
    val source: SourceApi,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
) {
    fun toDomain(): Article {
        return Article(
            author = author,
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt,
            content = content,
            source = source.toDomain()
        )
    }
}

@Serializable
data class SourceApi(
    val id: String?,
    val name: String
) {
    fun toDomain(): Source {
        return Source(
            id = id,
            name = name
        )
    }
}