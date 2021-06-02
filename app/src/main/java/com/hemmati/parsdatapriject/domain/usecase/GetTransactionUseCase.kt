package com.hemmati.parsdatapriject.domain.usecase

import com.hemmati.parsdatapriject.domain.dataAccess.repository.PostsRepository
import com.hemmati.parsdatapriject.domain.model.Post
import com.hemmati.parsdatapriject.domain.usecase.base.UseCase

class GetTransactionUseCase constructor(
    private val postsRepository: PostsRepository
) : UseCase<List<Post>, Any?>() {

    override suspend fun run(params: Any?): List<Post> {
        return postsRepository.getPosts()
    }

}