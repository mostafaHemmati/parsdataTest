package com.hemmati.parsdatapriject.domain.dataAccess.repository

import com.hemmati.parsdatapriject.domain.dataAccess.remot.ApiService
import com.hemmati.parsdatapriject.domain.model.Post

interface PostsRepository {

    suspend fun getPosts(): List<Post>
}

class GetPostsRepositoryImpl(private val apiService: ApiService) : PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }

}