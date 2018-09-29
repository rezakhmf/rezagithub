package com.reza.rezagithub.api

import com.reza.rezagithub.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("users/{user}")
    fun getUser(@Path("user") userId: String): Observable<User>
}