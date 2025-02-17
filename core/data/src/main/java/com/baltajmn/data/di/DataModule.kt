package com.baltajmn.data.di

import com.baltajmn.data.repository.DefaultNewsRepository
import com.baltajmn.data.repository.NewsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DataModule = module {
    singleOf(::DefaultNewsRepository) bind NewsRepository::class
}
