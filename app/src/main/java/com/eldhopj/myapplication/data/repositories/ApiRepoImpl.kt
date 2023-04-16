package com.eldhopj.myapplication.data.repositories

import com.eldhopj.myapplication.data.remote.service.ApiService
import com.eldhopj.myapplication.domain.repoInterface.ApiRepo
import com.eldhopj.myapplication.utils.bases.baseRepository.ApiCall
import com.eldhopj.myapplication.utils.bases.baseRepository.SafeApiCall
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Api repo
 *
 * @property apiService
 * @constructor Create empty Api repo
 */
@ViewModelScoped
class ApiRepoImpl @Inject constructor(private val apiService: ApiService) :
    ApiCall by SafeApiCall(), ApiRepo {

    // TODO :  Rename class with api path
    // Eg: /content/songs -> ContentApiRepo
}
