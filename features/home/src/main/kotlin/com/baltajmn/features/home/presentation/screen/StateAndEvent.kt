package com.baltajmn.features.home.presentation.screen

import androidx.compose.runtime.Immutable
import com.baltajmn.template.core.common.model.Article

@Immutable
data class HomeState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
)

interface Event