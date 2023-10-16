package com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.domain.SuspendUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.repos.ProductRepository
import com.yusufmendes.sisterslabgraduationproject.model.Product

class GetBagProductUseCase(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Unit, AppResult<Product>>() {
    override suspend fun execute(params: Unit): AppResult<Product> =
        productRepository.getBagProducts()
}