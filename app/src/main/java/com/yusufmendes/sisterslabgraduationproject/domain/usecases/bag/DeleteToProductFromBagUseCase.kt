package com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.domain.SuspendUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.repos.ProductRepository
import com.yusufmendes.sisterslabgraduationproject.model.CRUD

class DeleteToProductFromBagUseCase(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Int, AppResult<CRUD>>() {
    override suspend fun execute(params: Int): AppResult<CRUD> =
        productRepository.deleteToProductFromBag(params)
}