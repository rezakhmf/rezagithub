package com.reza.rezagithub.di

import com.reza.rezagithub.User
import com.reza.rezagithub.UserRepository
import com.reza.rezagithub.api.GithubApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(githubApiService: GithubApiService) = UserRepository(githubApiService)
}