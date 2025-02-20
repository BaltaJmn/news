package com.baltajmn.features.preferences.di

import com.baltajmn.features.preferences.presentation.screen.PreferencesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val PreferencesModule = module {
    includes(
        PreferencesDataModule,
        PreferencesDomainModule,
        PreferencesPresentationModule
    )
}

private val PreferencesDataModule: Module
    get() = module {}

private val PreferencesDomainModule: Module
    get() = module {}

private val PreferencesPresentationModule: Module
    get() = module {
        viewModelOf(::PreferencesViewModel)
    }