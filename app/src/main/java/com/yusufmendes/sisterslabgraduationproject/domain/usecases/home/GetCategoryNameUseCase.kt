package com.yusufmendes.sisterslabgraduationproject.domain.usecases.home

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.domain.SuspendUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.repos.ProductRepository
import com.yusufmendes.sisterslabgraduationproject.model.Category

class GetCategoryNameUseCase(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Unit, AppResult<Category>>() {
    override suspend fun execute(params: Unit): AppResult<Category> =
        productRepository.getCategoryName()
}