package com.eldhopj.myapplication.di

import com.eldhopj.myapplication.data.remote.handler.ApiHandler
import com.eldhopj.myapplication.data.repositories.ApiRepo
import com.eldhopj.myapplication.data.repositories.ApiRepoImpl
import dagger.Module
import dagger.Provides
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
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideEverythingRepo(handler: ApiHandler): ApiRepo =
        ApiRepoImpl(handler)
}
