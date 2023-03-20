package com.eldhopj.myapplication.data.repositories

import com.eldhopj.myapplication.data.remote.handler.ApiHandler
import com.eldhopj.myapplication.utils.bases.baseRepository.ApiCall
import com.eldhopj.myapplication.utils.bases.baseRepository.DbCall
import com.eldhopj.myapplication.utils.bases.baseRepository.SafeApiCall
import com.eldhopj.myapplication.utils.bases.baseRepository.SafeDbCall
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Api repo
 *
 * @property apiHandler
 * @constructor Create empty Api repo
 */
@ViewModelScoped
class ApiRepoImpl @Inject constructor(private val apiHandler: ApiHandler) :
    ApiCall by SafeApiCall(), DbCall by SafeDbCall(), ApiRepo {

    // TODO :  Rename class with api path
    // Eg: /content/songs -> ContentApiRepo
}
