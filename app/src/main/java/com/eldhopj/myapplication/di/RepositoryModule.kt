package com.eldhopj.myapplication.di

import com.eldhopj.myapplication.data.repositories.ApiRepoImpl
import com.eldhopj.myapplication.domain.repoInterface.ApiRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Repository module
 *
 * @constructor Create empty Repository module
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsApiRepo(apiRepoImpl: ApiRepoImpl): ApiRepo
}
