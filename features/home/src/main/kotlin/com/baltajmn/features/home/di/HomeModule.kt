package com.baltajmn.features.home.di

import com.baltajmn.features.home.domain.GetNews
import com.baltajmn.features.home.domain.GetNewsUseCase
import com.baltajmn.features.home.presentation.screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val HomeModule = module {
    includes(
        HomeDataModule,
        HomeDomainModule,
        HomePresentationModule
    )
}

private val HomeDataModule: Module
    get() = module {}

private val HomeDomainModule: Module
    get() = module {
        factory<GetNewsUseCase> { GetNews(get()) }
    }

private val HomePresentationModule: Module
    get() = module {
        viewModelOf(::HomeViewModel)
    }