package com.yusufmendes.sisterslabgraduationproject.data.di

import com.yusufmendes.sisterslabgraduationproject.data.repository.ProductRepositoryImpl
import com.yusufmendes.sisterslabgraduationproject.domain.repos.ProductRepository
import org.koin.dsl.module

val repoModules = module {
    includes(apiModule)

    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }
}