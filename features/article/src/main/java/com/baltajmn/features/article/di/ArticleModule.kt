package com.baltajmn.features.article.di

import com.baltajmn.features.article.presentation.screen.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val ArticleModule = module {
    includes(
        ArticleDataModule,
        ArticleDomainModule,
        ArticlePresentationModule
    )
}

private val ArticleDataModule: Module
    get() = module {}

private val ArticleDomainModule: Module
    get() = module {}

private val ArticlePresentationModule: Module
    get() = module {
        viewModelOf(::ArticleViewModel)
    }