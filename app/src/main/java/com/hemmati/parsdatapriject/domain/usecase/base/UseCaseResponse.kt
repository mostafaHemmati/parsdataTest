package com.hemmati.parsdatapriject.domain.usecase.base

import com.hemmati.parsdatapriject.domain.exeption.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

