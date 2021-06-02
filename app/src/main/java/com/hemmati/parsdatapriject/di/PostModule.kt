package com.hemmati.parsdatapriject.di

import com.hemmati.parsdatapriject.domain.dataAccess.remot.ApiService
import com.hemmati.parsdatapriject.domain.dataAccess.repository.GetPostsRepositoryImpl
import com.hemmati.parsdatapriject.domain.dataAccess.repository.PostsRepository
import com.hemmati.parsdatapriject.domain.usecase.GetTransactionUseCase
import com.hemmati.parsdatapriject.presentation.transaction.TransactionViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PostModule = module {

    viewModel { TransactionViewModel(get()) }

    single { createGetPostsUseCase(get()) }

    single { createPostRepository(get()) }
}

fun createPostRepository(apiService: ApiService): PostsRepository {
    return GetPostsRepositoryImpl(apiService)
}

fun createGetPostsUseCase(postsRepository: PostsRepository): GetTransactionUseCase {
    return GetTransactionUseCase(postsRepository)
}