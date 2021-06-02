package com.hemmati.parsdatapriject.domain.dataAccess.remot

import com.hemmati.parsdatapriject.domain.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>

}