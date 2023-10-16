package com.yusufmendes.sisterslabgraduationproject.domain.usecases.detail

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.domain.SuspendUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.repos.ProductRepository
import com.yusufmendes.sisterslabgraduationproject.model.AddToCardRequest
import com.yusufmendes.sisterslabgraduationproject.model.CRUD

class AddToBagUseCase(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<AddToCardRequest, AppResult<CRUD>>() {
    override suspend fun execute(params: AddToCardRequest): AppResult<CRUD> =
        productRepository.addToBag(params)
}