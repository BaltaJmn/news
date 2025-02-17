package com.baltajmn.features.home.presentation.screen

import androidx.compose.runtime.Immutable

@Immutable
data class HomeState(
    val isLoading: Boolean = false
)

interface Event