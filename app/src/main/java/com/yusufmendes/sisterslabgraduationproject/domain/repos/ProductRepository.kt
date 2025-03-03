package com.yusufmendes.sisterslabgraduationproject.domain.repos

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.model.AddToCardRequest
import com.yusufmendes.sisterslabgraduationproject.model.CRUD
import com.yusufmendes.sisterslabgraduationproject.model.Category
import com.yusufmendes.sisterslabgraduationproject.model.Product
import retrofit2.Response

interface ProductRepository {

    suspend fun getProducts(): AppResult<Product>

    suspend fun getBagProducts(): AppResult<Product>

    suspend fun searchProduct(query: String): AppResult<Product>

    suspend fun addToBag(addToCardRequest: AddToCardRequest): AppResult<CRUD>

    suspend fun deleteToProductFromBag(itemId: Int): AppResult<CRUD>

    suspend fun getCategory(category: String): AppResult<Product>

    suspend fun getCategoryName(): AppResult<Category>
}