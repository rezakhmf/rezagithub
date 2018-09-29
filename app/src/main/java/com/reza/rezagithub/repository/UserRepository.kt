package com.reza.rezagithub

import com.reza.rezagithub.api.GithubApiService

class UserRepository(private  val githubApiService: GithubApiService) {

    fun  getUser(userId: String) = this.githubApiService.getUser(userId)
}