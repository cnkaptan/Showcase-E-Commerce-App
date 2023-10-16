package com.yusufmendes.sisterslabgraduationproject.domain.di

import com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag.ClearBagUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag.DeleteToProductFromBagUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag.GetBagProductUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.detail.AddToBagUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.home.GetCategoryNameUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.home.GetCategoryUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.home.GetProductUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.usecases.home.SearchProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        ClearBagUseCase(get())
    }

    factory {
        DeleteToProductFromBagUseCase(get())
    }

    factory {
        GetBagProductUseCase(get())
    }

    factory {
        AddToBagUseCase(get())
    }

    factory {
        GetCategoryNameUseCase(get())
    }

    factory {
        GetCategoryUseCase(get())
    }

    factory {
        GetProductUseCase(get())
    }


    factory {
        SearchProductUseCase(get())
    }

}