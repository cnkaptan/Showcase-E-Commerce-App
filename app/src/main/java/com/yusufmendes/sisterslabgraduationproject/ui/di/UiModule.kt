package com.yusufmendes.sisterslabgraduationproject.ui.di

import com.yusufmendes.sisterslabgraduationproject.ui.view.bag.BagViewModel
import com.yusufmendes.sisterslabgraduationproject.ui.view.detail.DetailViewModel
import com.yusufmendes.sisterslabgraduationproject.ui.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// use Constructor DSL dsl in koin
val uiModule = module {
    viewModel { BagViewModel(get(), get(), get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { HomeViewModel(get(), get(), get(), get()) }
}