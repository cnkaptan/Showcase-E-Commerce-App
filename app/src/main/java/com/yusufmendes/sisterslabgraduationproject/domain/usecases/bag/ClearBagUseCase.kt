package com.yusufmendes.sisterslabgraduationproject.domain.usecases.bag

import com.yusufmendes.sisterslabgraduationproject.domain.AppResult
import com.yusufmendes.sisterslabgraduationproject.domain.SuspendUseCase
import com.yusufmendes.sisterslabgraduationproject.domain.attempt
import com.yusufmendes.sisterslabgraduationproject.domain.get
import com.yusufmendes.sisterslabgraduationproject.model.ProductX
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope

class ClearBagUseCase(
    private val deleteToProductFromBagUseCase: DeleteToProductFromBagUseCase
) :
    SuspendUseCase<List<ProductX>, AppResult<Unit>>() {
    override suspend fun execute(params: List<ProductX>): AppResult<Unit> {
        return attempt {
            supervisorScope {
                params.map {
                    async {
                        deleteToProductFromBagUseCase.invoke(it.id).get()
                    }
                }.awaitAll()
            }
        }
    }
}