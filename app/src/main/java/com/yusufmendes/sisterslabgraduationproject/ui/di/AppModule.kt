package com.yusufmendes.sisterslabgraduationproject.ui.di

import com.yusufmendes.sisterslabgraduationproject.data.di.repoModules
import com.yusufmendes.sisterslabgraduationproject.domain.di.useCaseModule

val appModule = listOf(
    repoModules,
    useCaseModule,
    uiModule
)