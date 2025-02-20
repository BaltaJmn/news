package com.baltajmn.features.article.presentation.screen

import androidx.compose.runtime.Immutable
import com.baltajmn.template.core.common.model.Article

@Immutable
data class State(
    val isLoading: Boolean = false,
    val article: Article? = null
)

interface Event